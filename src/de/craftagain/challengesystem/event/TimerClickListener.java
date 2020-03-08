package de.craftagain.challengesystem.event;

import de.craftagain.challengesystem.inventory.INV_Timer;
import de.craftagain.challengesystem.inventory.Inventories;
import de.craftagain.challengesystem.utils.config.Config;
import de.craftagain.challengesystem.utils.timer.Timer;
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
                //Count up selection
                if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§aHochzählend") || event.getCurrentItem().getItemMeta().getDisplayName().equals("§5Hochzählend")){
                    new Timer().stop();
                    Inventories.TIMER.setItem(11, INV_Timer.count_up_active);
                    Inventories.TIMER.setItem(15, INV_Timer.count_down);
                    player.openInventory(Inventories.COUNT_UP_SETTINGS);

                    Config.setTimerType("count_up");

                }
                //Count down selection
                if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§aRunterzählend") || event.getCurrentItem().getItemMeta().getDisplayName().equals("§5Runterzählend")){
                    new Timer().stop();
                    Inventories.TIMER.setItem(11, INV_Timer.count_up);
                    Inventories.TIMER.setItem(15, INV_Timer.count_down_active);
                    player.openInventory(Inventories.COUNT_DOWN_SETTINGS);

                    Config.setTimerType("count_down");
                }

            }

        }catch(Exception e){

        }
    }

}
