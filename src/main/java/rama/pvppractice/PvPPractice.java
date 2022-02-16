package rama.pvppractice;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class PvPPractice extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ListenerClass(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
