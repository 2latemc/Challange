package at.late.secredchallange;

import at.late.secredchallange.listeners.OnAnyMovement;
import at.late.secredchallange.listeners.OnJoin;
import at.late.secredchallange.listeners.OnOffhandSwap;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {

    public static String prefix = "§c§lChallange§7 | §f";
    public static HashMap<Player, State> states = new HashMap<>();

    @Override
    public void onEnable() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new OnAnyMovement(), this);
        manager.registerEvents(new OnJoin(), this);
        manager.registerEvents(new OnOffhandSwap(), this);

        Bukkit.getConsoleSender().sendMessage(prefix + "Erfolgreich geladen!");

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "Erfolgreich gestoppt!");
    }

    public static void playSoundSucces(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3.0f, 1.0f);
    }
}
