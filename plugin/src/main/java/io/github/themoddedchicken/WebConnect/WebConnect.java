package io.github.themoddedchicken.WebConnect;

import java.sql.SQLException;
import java.util.logging.Logger;

import io.github.themoddedchicken.WebConnect.lib.managers.WebManager;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.geyser.api.GeyserApi;
import io.github.themoddedchicken.WebConnect.lib.managers.DatabaseManager;

public class WebConnect extends JavaPlugin implements Listener {
    public WebConnect plugin;
    public FloodgateApi floodgate;
    public GeyserApi geyser;
    public WebManager webManager;
    public DatabaseManager databaseManager;
    public Logger logger;
    public Server server;
    public BukkitScheduler scheduler;
    public ConsoleCommandSender console;
    public FileConfiguration config;

    @Override
    public void onEnable() {
        saveResource("config.yml", false);

        this.plugin = this;
        this.geyser = GeyserApi.api();
        this.floodgate = FloodgateApi.getInstance();
        this.config = getConfig();
        this.logger = getLogger();
        this.server = getServer();
        this.scheduler = this.server.getScheduler();
        this.console = this.server.getConsoleSender();

        webManager = new WebManager(
                plugin,
                config.getInt("port", 7395),
                config.getString("path", "/"),
                config.getBoolean("external-panel", false)
        );

        try {
            databaseManager = new DatabaseManager(plugin);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        Bukkit.getPluginManager().registerEvents(this, this);
    }
}