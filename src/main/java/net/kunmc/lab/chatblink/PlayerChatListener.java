package net.kunmc.lab.chatblink;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerChatListener implements Listener {

    private final ChatBlink chatBlink;

    public PlayerChatListener(ChatBlink chatBlink_) {
        chatBlink = chatBlink_;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        chatBlink.getServer().getScheduler().runTask(chatBlink, new Runnable() {
            @Override
            public void run() {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 10));
            }
        });
    }

}
