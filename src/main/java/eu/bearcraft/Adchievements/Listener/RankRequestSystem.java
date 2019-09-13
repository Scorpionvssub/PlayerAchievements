package eu.bearcraft.Adchievements.Listener;

import eu.bearcraft.Adchievements.PlayerAchievements;
import eu.bearcraft.Adchievements.PlayerStats;
import eu.bearcraft.Global.CustomListeners.OpenRankSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Collections;
import java.util.List;

public class RankRequestSystem implements Listener {


    @EventHandler
    public void onRequest(OpenRankSystem event) {
        Player player = event.getPlayer();
        String rank = event.getRank();

        int id = 0;
        List<String> list = PlayerAchievements.getInstance().getRankAchSystem().getRankReqs(rank);
        if (list == null) return;
        for (String key : list) {
            PlayerAchievements.getInstance().getApi().setRequirement(PlayerAchievements.getInstance().getName()+id, rank, getPlayerSituation(key, player));
            id++;
        }
    }

    private List<String> getPlayerSituation(String key, Player player) {
        String[] split = key.split(":");
        boolean hasStat = new PlayerStats(split, player).getStatus();
        return Collections.singletonList(hasStat ? split[1] : split[2]);
    }
}
