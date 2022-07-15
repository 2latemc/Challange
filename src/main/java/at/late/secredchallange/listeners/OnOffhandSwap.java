package at.late.secredchallange.listeners;

import at.late.secredchallange.Main;
import at.late.secredchallange.State;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnOffhandSwap implements Listener {
    @EventHandler
    public void keyDown(PlayerSwapHandItemsEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();
        Main.playSoundSucces(player);
        if(Main.states.get(player) == State.CANTWALK) {
            Main.states.put(player, State.BLIND);
            player.removePotionEffect(PotionEffectType.SLOW);
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 255, true, false));
            player.sendMessage(Main.prefix + "Du bist nun Blind!");
        } else {
            Main.states.put(player, State.CANTWALK);
            player.removePotionEffect(PotionEffectType.BLINDNESS);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 255, true, false));
            player.sendMessage(Main.prefix + "Du kannst nun nicht mehr gehen!");
        }
    }
}
