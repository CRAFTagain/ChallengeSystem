package de.craftagain.challengesystem.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class INV_Menu implements IInventory {

    static Inventory inv = Inventories.MENU;

    public void registerInventory() {

        ItemStack edge = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);

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
    }
}
