package eu.bearcraft.Adchievements;

import API.BCRanksAPI;
import eu.bearcraft.Adchievements.Listener.RankRequestSystem;
import eu.bearcraft.Adchievements.Ranks.RankAchSystem;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerAchievements extends JavaPlugin {

    private BCRanksAPI api;
    private static PlayerAchievements instance;
    private RankAchSystem rankAchSystem;

    public static PlayerAchievements getInstance() {
        return instance;
    }

    public void onEnable() {
        if (getServer().getPluginManager().isPluginEnabled("BCRanks")) {
            api = BCRanksAPI.getApi();
        } else {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        rankAchSystem = new RankAchSystem();
        rankAchSystem.setup(this);

        getServer().getPluginManager().registerEvents(new RankRequestSystem(), this);
    }

    public BCRanksAPI getApi() {
        return api;
    }

    public RankAchSystem getRankAchSystem() {
        return rankAchSystem;
    }
}
