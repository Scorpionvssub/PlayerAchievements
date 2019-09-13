package eu.bearcraft.Adchievements.Ranks;

import eu.bearcraft.Adchievements.PlayerAchievements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankAchSystem {

    private PlayerAchievements pa;

    public List<String> getRankReqs(String key) {
        return rankReqs.get(key);
    }

    private Map<String, List<String>> rankReqs = new HashMap<>();

    public void setup(PlayerAchievements playerAchievements) {
        pa = playerAchievements;
        for (String key : pa.getConfig().getConfigurationSection("Ranks").getKeys(false)) {
            List<String> value = pa.getConfig().getStringList("Ranks." + key + ".achievementList");
            rankReqs.put(key, value);
        }
    }
}
