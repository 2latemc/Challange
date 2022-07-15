package at.late.secredchallange.listeners;

import at.late.secredchallange.Main;
import at.late.secredchallange.State;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnAnyMovement implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(Main.states.get(player) == State.CANTWALK) {
            event.setCancelled(true);
        }
    }
}
