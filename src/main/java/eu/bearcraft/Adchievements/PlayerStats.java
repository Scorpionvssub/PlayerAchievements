package eu.bearcraft.Adchievements;

import org.bukkit.Achievement;
import org.bukkit.entity.Player;

public class PlayerStats {

    private String[] split;
    private Player player;
    public PlayerStats(String[] split, Player player) {
        this.split = split;
        this.player = player;
    }


    public boolean getStatus() {
        try {
            return getAd(split[0].toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean getAd(String achievement) {
        return player.hasAchievement(Achievement.valueOf(achievement));
    }
}
