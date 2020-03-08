package de.craftagain.challengesystem.inventory;

import de.craftagain.challengesystem.api.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class INV_CountUpSettings implements IInventory {

    static Inventory inv = Inventories.COUNT_UP_SETTINGS;

    static ItemStack more_time = ItemBuilder.createItem(Material.GREEN_DYE, "§a+10 min", false);
    static ItemStack less_time = ItemBuilder.createItem(Material.RED_DYE, "§a-10 min", false);

    @Override
    public void registerInventory() {

        inv.setItem(11, more_time);
        inv.setItem(15, less_time);

    }
}
