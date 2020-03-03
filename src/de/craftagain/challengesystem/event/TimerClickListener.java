package de.craftagain.challengesystem.event;

import de.craftagain.challengesystem.inventory.INV_Timer;
import de.craftagain.challengesystem.inventory.Inventories;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TimerClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player)event.getWhoClicked();

        try {
            if (event.getView().getTitle().equals("§8Timer")) {
                event.setCancelled(true);
                if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§7Zurück")){
                    player.openInventory(Inventories.MENU);
                }
                if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§aHochzählend")){
                    Inventories.TIMER.setItem(11, INV_Timer.count_up_active);
                    Inventories.TIMER.setItem(15, INV_Timer.count_down);
                }
                if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§aRunterzählend")){
                    Inventories.TIMER.setItem(11, INV_Timer.count_up);
                    Inventories.TIMER.setItem(15, INV_Timer.count_down_active);
                }

            }

        }catch(Exception e){

        }
    }

}
