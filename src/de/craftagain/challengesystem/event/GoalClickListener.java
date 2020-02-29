package de.craftagain.challengesystem.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GoalClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();

        try {
            if (event.getView().getTitle().equals("§8Ziele")) {
                event.setCancelled(true);
            }
        }catch(NullPointerException e){

        }
    }

}
