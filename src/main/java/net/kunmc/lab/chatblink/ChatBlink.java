package net.kunmc.lab.chatblink;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public final class ChatBlink extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        double blinkRate = Double.parseDouble(config.getString("blinkRate"));
        int blinkTick = Integer.parseInt(config.getString("blinkTick"));
        int timerInterval = Integer.parseInt(config.getString("timerInterval"));

        getServer().getPluginManager().registerEvents(new PlayerChatListener(this, blinkRate, blinkTick, timerInterval), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
