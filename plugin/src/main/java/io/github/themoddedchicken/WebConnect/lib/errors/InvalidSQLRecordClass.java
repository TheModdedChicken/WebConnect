package io.github.themoddedchicken.WebConnect.lib.errors;

public class InvalidSQLRecordClass extends RuntimeException {
	public InvalidSQLRecordClass(String name) {
		super("Class with name '" + name + "' isn't annotated with '@SQLRecord'.");
	}
}
