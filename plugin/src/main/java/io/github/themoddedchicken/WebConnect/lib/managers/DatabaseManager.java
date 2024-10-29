package io.github.themoddedchicken.WebConnect.lib.managers;

import io.github.themoddedchicken.WebConnect.WebConnect;
import io.github.themoddedchicken.WebConnect.lib.records.Guest;
import io.github.themoddedchicken.WebConnect.lib.records.Invite;
import io.github.themoddedchicken.WebConnect.lib.records.User;
import io.github.themoddedchicken.WebConnect.lib.utilities.SQLUtility;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DatabaseManager {
    public final SQLUtility.Database database;
    private final WebConnect plugin;

    public DatabaseManager (WebConnect plugin) throws ClassNotFoundException, SQLException {
        this.plugin = plugin;

        final String db_file_name = "database.db";
        File DBFile = new File(this.plugin.getDataFolder(), db_file_name);
        if (!DBFile.exists()) {
            try {
                DBFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        this.database = new SQLUtility.Database("jdbc:sqlite:plugins/" + this.plugin.getName() + "/" + db_file_name);

        /* Initialize tables if non-existent */
        database.createTable(User.class);
        database.createTable(Guest.class);
        database.createTable(Invite.class);
    }
}
