package net.kunmc.lab.chatblink;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    private final ChatBlink chatBlink;

    /**
     * チャットの文字数にかけ合わせてまばたきの回数を決める
     */
    private double blinkRate = 1.0;

    private int blinkTick = 20;

    private int timerInterval = 20;

    /**
     * @param chatBlink_
     * @param blinkRate
     * @param blinkTick
     * @param timerInterval
     */
    public PlayerChatListener(ChatBlink chatBlink_, double blinkRate, int blinkTick, int timerInterval) {
        chatBlink = chatBlink_;
        this.blinkRate = blinkRate;
        this.blinkTick = blinkTick;
        this.timerInterval = timerInterval;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        int blinkTime = (int) (event.getMessage().length() * blinkRate);

        new BlinkRunnable(event.getPlayer(), blinkTime, blinkTick).runTaskTimer(chatBlink, 0, timerInterval);
    }
}
