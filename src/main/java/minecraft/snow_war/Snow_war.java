package minecraft.snow_war;

import commands.Start_FightCommand;
import events.PlayerEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class Snow_war extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getCommand("start_fight").setExecutor(new Start_FightCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
