package io.github.themoddedchicken.WebConnect.lib.utilities;

import io.github.themoddedchicken.WebConnect.lib.annotations.sql.Field;
import io.github.themoddedchicken.WebConnect.lib.annotations.sql.Table;
import io.github.themoddedchicken.WebConnect.lib.errors.InvalidSQLRecordClass;
import io.github.themoddedchicken.WebConnect.lib.interfaces.IDatabaseConditionHandler;
import io.github.themoddedchicken.WebConnect.lib.interfaces.IDatabaseStatementHandler;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

public class SQLUtility {
	public static class Database {
		Connection connection;

		public Database(String url) throws ClassNotFoundException, SQLException {
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager.getConnection(url);
		}

		/**
		 * Execute SQL statement
		 * @param sql SQL statement
		 * @param handler Statement execution handler
		 */
		public void executeStatement(String sql, IDatabaseStatementHandler handler) throws SQLException {
			PreparedStatement statement = this.connection.prepareStatement(sql);

			handler.handle(statement);

			statement.close();
		}

		/**
		 * Create a new table in database using an @SQLTable annotated Class, if it doesn't already exist
		 * @param schema SQL schema
		 */
		public <O> void createTable(Class<O> schema) throws SQLException {
			if (schema.isAnnotationPresent(Table.class)) {
				// Get table name
				String table = schema.getAnnotation(Table.class).value();

				// Get fields with type modifiers
				String[] fields = Arrays.stream(schema.getDeclaredFields())

					// Filter non-SQL Fields
					.filter(field -> field.isAnnotationPresent(Field.class))

					// Convert Fields to Strings with type modifiers
					.map(field -> String.join(
						" ",
						field.getName(),                                        // Get name
						SQLUtility.getType(field.getClass()),                	// Get type
						field.getClass().getAnnotation(Field.class).value()) // Get type modifiers
					)

					// Convert Stream to Array
					.toArray(String[]::new);

				createTable(table, fields);
			}

			throw new InvalidSQLRecordClass(schema.getName());
		}

		/**
		 * Create new table in database, if it doesn't already exist
		 * @param name Name of table
		 * @param fields Table fields with types
		 */
		public void createTable(String name, String... fields) throws SQLException {
			executeStatement(
				"CREATE TABLE IF NOT EXISTS " + name +  "(" + String.join(", ", fields) + ")",
				PreparedStatement::execute
			);
		}

		/**
		 * Drop table in database if it exists
		 * @param name Name of table
		 */
		public void dropTable(String name) throws SQLException {
			executeStatement(
				"DROP TABLE IF EXISTS " + name,
				PreparedStatement::execute
			);
		}

		/**
		 * Dynamically insert record into specified table based on passed object fields
		 * @param record Record to insert
		 */
		public <O> void insertRecord(O record) throws SQLException, InvalidSQLRecordClass {
			if (record.getClass().isAnnotationPresent(Table.class)) {
				// Get table name
				String table = SQLUtility.getTable(record.getClass());

				java.lang.reflect.Field[] fields = SQLUtility.getInitializedFields(record);

				// Get SQL field names
				String[] field_names = Arrays
					.stream(fields)
					.map(java.lang.reflect.Field::getName)
					.toArray(String[]::new);

				executeStatement(
					// Insert record into table or update if already exists
					("INSERT INTO " + table)
						+ ("(" + String.join(", ", field_names) + ")")
						+ " VALUES "
						+ ("(" + StringUtility.repeat(", ", "?", fields.length) + ")"),

					(statement -> {
						try {
							// Set statement values
							int i = 1;
							for (; i <= fields.length; i++)
								statement.setObject(i, fields[i - 1].get(record));
						} catch (IllegalAccessException e) {
							throw new RuntimeException(e);
						}
					})
				);
			}

			throw new InvalidSQLRecordClass(record.getClass().getName());
		}

		public <O> void updateRecord(O record, String condition, IDatabaseConditionHandler handler) throws SQLException {
			if (record.getClass().isAnnotationPresent(Table.class)) {
				// Get table name
				String table = SQLUtility.getTable(record.getClass());

				java.lang.reflect.Field[] fields = SQLUtility.getInitializedFields(record);

				// Create field setters (field_name=?)
				String[] field_setters = Arrays
					.stream(fields)
					.map(field -> field.getName() + "=?")
					.toArray(String[]::new);

				executeStatement(
					// Update record with new data
					("UPDATE " + table)
						+ " SET "
						+ ("(" + String.join(", ", field_setters) + ")")
						+ " WHERE "
						+ condition,

					(statement -> {
						try {
							// Set statement values
							int i = 1;
							for (; i <= fields.length; i++)
								statement.setObject(i, fields[i - 1].get(record));

							handler.handle(statement, i);
						} catch (IllegalAccessException e) {
							throw new RuntimeException(e);
						}
					})
				);
			}

			throw new InvalidSQLRecordClass(record.getClass().getName());
		}

		public <O> void deleteRecord(Class<O> table_class, String condition, IDatabaseConditionHandler handler) throws SQLException {
			if (table_class.isAnnotationPresent(Table.class)) {
				// Get table name
				String table = SQLUtility.getTable(table_class);

				executeStatement(
					// Delete
					("DELETE FROM " + table) + " WHERE " + condition,

					(statement -> handler.handle(statement, 1))
				);
			}

			throw new InvalidSQLRecordClass(table_class.getName());
		}
	}

	public static <O> String getType(Class<O> c) {
		if (c == String.class) return "TEXT";
		if (c == int.class) return "INTEGER";
		if (c == Date.class) return "DATE";
		if (c == Array.class) return getType(c.arrayType()) + "[]";

		return "NULL";
	}

	public static <O> String getTable(Class<O> c) {
		return c.getAnnotation(Table.class).value();
	}

	public static <O> java.lang.reflect.Field[] getInitializedFields(O obj) {
		return Arrays
			.stream(SQLUtility.getFields(obj.getClass()))

			// Filter out uninitialized fields
			.filter(field -> {
				try {
					return !Objects.isNull(field.get(obj));
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			})

			.toArray(java.lang.reflect.Field[]::new);
	}

	public static <O> java.lang.reflect.Field[] getFields(Class<O> c) {
		return Arrays
			.stream(c.getFields())

			// Filter non-SQL Fields
			.filter(field -> field.isAnnotationPresent(Field.class))

			.toArray(java.lang.reflect.Field[]::new);
	}
}
