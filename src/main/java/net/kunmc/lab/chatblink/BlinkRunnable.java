package net.kunmc.lab.chatblink;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;

public class BlinkRunnable extends BukkitRunnable {

    private Player player;

    private int count = 1;

    private int countLimit = 0;

    private int blinkTick = 0;

    /**
     * 付与するポーションレベル
     */
    private final int POTION_LEVEL = 10;

    public BlinkRunnable(Player player, int countLimit, int blinkTick) {
        this.player = player;
        this.countLimit = countLimit;
        this.blinkTick = blinkTick;
    }

    public void run() {
        Location location = player.getLocation();
        location.setY(location.getY() + 1);

        location.getWorld().spawnParticle(
                Particle.VILLAGER_ANGRY,
                location,
                1
        );
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, blinkTick, POTION_LEVEL));
        count++;
        if (count > countLimit) {
            cancel();
        }
    }
}
