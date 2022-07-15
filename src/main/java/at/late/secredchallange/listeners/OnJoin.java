package at.late.secredchallange.listeners;

import at.late.secredchallange.Main;
import at.late.secredchallange.State;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(!Main.states.containsKey(player)) {
            Main.states.put(player, State.BLIND);
            player.sendMessage(Main.prefix + "Drücke F um deinen Modus zu ändern!");
        }

        if(Main.states.get(player) == State.BLIND) {
            player.removePotionEffect(PotionEffectType.SLOW);
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 255, true, false));
        } else {
            player.removePotionEffect(PotionEffectType.BLINDNESS);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 255, true, false));
        }
    }
}
