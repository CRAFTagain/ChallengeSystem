package de.craftagain.challengesystem.inventory;

import de.craftagain.challengesystem.api.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class INV_Goals implements IInventory {

    private static Inventory inv = Inventories.GOALS;

    private static ItemStack edge = ItemBuilder.createItem(Material.GRAY_STAINED_GLASS_PANE, " ", false);

    private static ItemStack mc = ItemBuilder.createItem(Material.GRASS_BLOCK, "§aMinecraft durchspielen", false);
    private static ItemStack block = ItemBuilder.createItem(Material.QUARTZ_BLOCK, "§aAls Erster einen Block besitzen", false);
    private static ItemStack nether = ItemBuilder.createItem(Material.NETHERRACK, "§aAls Erster den Nether erreichen", false);
    private static ItemStack end = ItemBuilder.createItem(Material.END_STONE, "§aAls Erster das End erreichen", false);


    @Override
    public void registerInventory() {

        //Design
        for(int i = 0; i < 9; i++){
            inv.setItem(i, edge);
        }

        inv.setItem(9, edge);
        inv.setItem(17, edge);

        for(int i = 18; i > 17 && i < 27; i++){
            inv.setItem(i, edge);
        }

        inv.setItem(10, mc);
        inv.setItem(12, block);
        inv.setItem(14, nether);
        inv.setItem(16, end);

    }
}
