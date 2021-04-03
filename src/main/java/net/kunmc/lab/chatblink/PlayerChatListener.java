package net.kunmc.lab.chatblink;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Location;

public class PlayerChatListener implements Listener {

    private final ChatBlink chatBlink;

    /**
     * チャットの文字数にかけ合わせてまばたきの回数を決める
     */
    private double blinkRate = 1.0;

    /**
     * @param chatBlink_
     * @param blinkRate
     */
    public PlayerChatListener(ChatBlink chatBlink_, double blinkRate) {
        chatBlink = chatBlink_;
        this.blinkRate = blinkRate;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        int blinkTime = (int) (event.getMessage().length() * blinkRate);

        new BlinkRunnable(event.getPlayer(), blinkTime).runTaskTimer(chatBlink, 0, 20);
    }
}
