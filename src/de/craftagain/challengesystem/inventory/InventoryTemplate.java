package de.craftagain.challengesystem.inventory;

import de.craftagain.challengesystem.api.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryTemplate {

    private static ItemStack edge = ItemBuilder.createItem(Material.BLACK_STAINED_GLASS_PANE, " ", false);
    private static ItemStack back = ItemBuilder.createItem(Material.ARROW, "§7Zurück", false);

    public static Inventory createNewInventory(String name){

       Inventory inv = Bukkit.createInventory(null, 9*3, name);
        //Design
        for(int i = 0; i < 9; i++){
            inv.setItem(i, edge);
        }

        inv.setItem(9, edge);
        inv.setItem(17, edge);

        for(int i = 18; i > 17 && i < 27; i++){
            inv.setItem(i, edge);
        }
        inv.setItem(18, back);
        return inv;

    }
}
