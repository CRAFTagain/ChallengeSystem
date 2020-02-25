package de.craftagain.challengesystem.inventory;

import de.craftagain.challengesystem.api.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class INV_Menu implements IInventory {

    //Inventory
    static Inventory inv = Inventories.MENU;

    //Items
    static ItemStack goals = ItemBuilder.createItem(Material.NETHER_STAR, "§aZiele", false);
    static ItemStack edge = ItemBuilder.createItem(Material.BLACK_STAINED_GLASS_PANE, " ", false);

    public void registerInventory() {


        for(int i = 0; i < 9; i++){
            inv.setItem(i, edge);
        }
        inv.setItem(9, edge);
        inv.setItem(18, edge); inv.setItem(17, edge);
        inv.setItem(27, edge); inv.setItem(26, edge);
        inv.setItem(36, edge); inv.setItem(35, edge);

        for(int i = 36; i > 35 && i < 45; i++){
            inv.setItem(i, edge);
        }

        inv.setItem(19, goals);

    }
}
