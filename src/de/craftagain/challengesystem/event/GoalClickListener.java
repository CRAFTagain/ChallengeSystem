package de.craftagain.challengesystem.event;

import de.craftagain.challengesystem.inventory.INV_Goals;
import de.craftagain.challengesystem.inventory.Inventories;
import de.craftagain.challengesystem.utils.config.Config;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class GoalClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) throws IOException {
        Player player = (Player)event.getWhoClicked();

        try {
            if (event.getView().getTitle().equals("§8Ziele")) {
                event.setCancelled(true);
                int lastActiveItemSlot;
                ItemStack replaceItem;
                String lastGoal = Config.getGoal();

                //Finds out what the last active Goal was
                switch(lastGoal){

                    case "mc":
                        lastActiveItemSlot = 10;
                        replaceItem = INV_Goals.mc;
                        break;
                    case "block":
                        lastActiveItemSlot = 12;
                        replaceItem = INV_Goals.block;
                        break;
                    case "nether":
                        lastActiveItemSlot = 14;
                        replaceItem = INV_Goals.nether;
                        break;
                    case "end":
                        lastActiveItemSlot = 16;
                        replaceItem = INV_Goals.end;
                        break;
                    default:
                        lastActiveItemSlot = 28;
                        replaceItem = new ItemStack(Material.DIRT);
                        break;
                }
                    //Checks which goal is clicked
                    if(event.getCurrentItem().equals(INV_Goals.mc)){
                        Inventories.GOALS.setItem(lastActiveItemSlot, replaceItem);
                        Inventories.GOALS.setItem(10, INV_Goals.mc_active);
                    Config.setGoal("mc");
                    }
                    if(event.getCurrentItem().equals(INV_Goals.block)){
                        Inventories.GOALS.setItem(lastActiveItemSlot, replaceItem);
                        Inventories.GOALS.setItem(12, INV_Goals.block_active);
                    Config.setGoal("block");
                    }
                    if(event.getCurrentItem().equals(INV_Goals.nether)){
                        Inventories.GOALS.setItem(lastActiveItemSlot, replaceItem);
                        Inventories.GOALS.setItem(14, INV_Goals.nether_active);
                    Config.setGoal("nether");
                    }
                    if(event.getCurrentItem().equals(INV_Goals.end)){
                        Inventories.GOALS.setItem(lastActiveItemSlot, replaceItem);
                        Inventories.GOALS.setItem(16, INV_Goals.end_active);
                    Config.setGoal("end");
                    }

                    //Checks if the player wants to go back to the main menu
                    if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§7Zurück")){
                        player.openInventory(Inventories.MENU);
                    }
            }
        }catch(NullPointerException e){

        }
    }

}
