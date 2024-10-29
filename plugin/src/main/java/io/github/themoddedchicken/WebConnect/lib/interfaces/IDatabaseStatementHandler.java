package io.github.themoddedchicken.WebConnect.lib.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IDatabaseStatementHandler {
    void handle(PreparedStatement statement) throws SQLException;
}
