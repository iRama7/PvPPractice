package rama.pvppractice;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class PvPPractice extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6PvP-Practice&8] &7Loading &6PvP-Practice &7by &eImRama"));

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ListenerClass(this), this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6PvP-Practice&8] &7Registering events..."));

        this.getCommand("practice").setExecutor(new ComandoMain());
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6PvP-Practice&8] &7Loading commands..."));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
