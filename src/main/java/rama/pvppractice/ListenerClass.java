package rama.pvppractice;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ListenerClass implements Listener {

    private PvPPractice plugin;

    public ListenerClass(PvPPractice plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent e){

        FileConfiguration config = plugin.getConfig();

        Player player = e.getPlayer();


            int X = player.getLocation().getBlockX();
            int Z = player.getLocation().getBlockZ();

            int P1X = -6046;
            int P1Z = 181;

            int P2X = -5845;
            int P2Z = -20;

            Boolean isBetweenCoords = X > P1X && X < P2X && Z > P2Z && Z < P1Z;
            Boolean isInWorld = player.getWorld().getName().equalsIgnoreCase("spawn");

            if (isBetweenCoords && isInWorld) {
                if (!player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {

                    PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 255);
                    player.addPotionEffect(effect);
                }
            } else {
                if (player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
                    player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                }
            }


    }
    @EventHandler
    public void ItemDamageEvent(PlayerItemDamageEvent e){
        Player player = e.getPlayer();

        int X = player.getLocation().getBlockX();
        int Z = player.getLocation().getBlockZ();

        int P1X = -6046;
        int P1Z = 181;

        int P2X = -5845;
        int P2Z = -20;

        Boolean isInRegion = X > P1X && X < P2X && Z > P2Z && Z < P1Z;

        if(isInRegion){
            e.setCancelled(true);
        }return;


    }
}