package de.craftagain.challengesystem.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player)event.getWhoClicked();

        if(event.getView().getTitle().equalsIgnoreCase("§8Einstellungen")){
            event.setCancelled(true);
        }
    }

}
