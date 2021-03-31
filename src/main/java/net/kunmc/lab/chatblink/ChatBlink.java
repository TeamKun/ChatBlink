package net.kunmc.lab.chatblink;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatBlink extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerChatListener(this),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
