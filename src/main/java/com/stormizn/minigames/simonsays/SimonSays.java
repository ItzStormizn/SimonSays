package com.stormizn.minigames.simonsays;

import com.stormizn.minigames.simonsays.manager.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class SimonSays extends JavaPlugin {

    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {

        getLogger().info("SimonSays has been successfully enabled!");
        getLogger().info("Try running /help SimonSays to see the available commands");

        saveDefaultConfig();

        databaseManager = new DatabaseManager(this, getConfig().getString("host"), getConfig().getInt("port"), getConfig().getString("database"), getConfig().getString("username"), getConfig().getString("password"));
        try {
            databaseManager.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Database connected successfully!");

    }

    @Override
    public void onDisable() {

        getLogger().info("SimonSays has been successfully disabled!");

        databaseManager.disconnect();

    }
}
