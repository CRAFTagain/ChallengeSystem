package de.craftagain.challengesystem.event;

import de.craftagain.challengesystem.inventory.Inventories;
import de.craftagain.challengesystem.utils.timer.Timer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CountUpSettingsClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player)event.getWhoClicked();

        try {
            if (event.getClickedInventory().equals(Inventories.COUNT_UP_SETTINGS)) {
                event.setCancelled(true);

                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§7Zurück")) {
                    player.openInventory(Inventories.TIMER);
                }

                if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§a+10 min")){
                    new Timer().stop();
                    new Timer().addTime(0, 10, 0);
                }
                if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§a-10 min")){
                    new Timer().stop();
                    new Timer().removeTime(0, 10, 0);
                }

            }
        }catch(Exception e){

        }
    }

}
