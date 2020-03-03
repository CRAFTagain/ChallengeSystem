package de.craftagain.challengesystem.event;

import de.craftagain.challengesystem.inventory.Inventories;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();

        //Settings
        try {
            if (event.getView().getTitle().equals("§8Einstellungen")) {
                event.setCancelled(true);
                //Goals
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aZiele")) {
                    player.openInventory(Inventories.GOALS);
                }
                //Timer
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aTimer")) {
                    player.openInventory(Inventories.TIMER);
                }
            }
        }catch(NullPointerException e){

        }
    }

}
