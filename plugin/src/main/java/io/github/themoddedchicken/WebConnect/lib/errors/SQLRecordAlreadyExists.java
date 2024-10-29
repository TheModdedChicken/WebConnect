package io.github.themoddedchicken.WebConnect.lib.errors;

public class SQLRecordAlreadyExists extends RuntimeException {
	public SQLRecordAlreadyExists(String id) {
		super("User with ID '" + id + "' already exists.");
	}
}
