package io.github.themoddedchicken.WebConnect.lib.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IDatabaseConditionHandler {
	void handle(PreparedStatement statement, int parameter) throws SQLException;
}
