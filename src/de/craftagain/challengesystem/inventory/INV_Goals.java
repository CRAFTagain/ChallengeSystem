package de.craftagain.challengesystem.inventory;

import de.craftagain.challengesystem.api.ItemBuilder;
import de.craftagain.challengesystem.utils.config.Config;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class INV_Goals implements IInventory {

    private static Inventory inv = Inventories.GOALS;

    //Items

    public static ItemStack mc = ItemBuilder.createItem(Material.GRASS_BLOCK, "§aMinecraft durchspielen", false);
    public static ItemStack mc_active = ItemBuilder.createItem(Material.GRASS_BLOCK, "§5Minecraft durchspielen", true);

    public static ItemStack block = ItemBuilder.createItem(Material.QUARTZ_BLOCK, "§aAls Erster einen Block besitzen", false);
    public static ItemStack block_active = ItemBuilder.createItem(Material.QUARTZ_BLOCK, "§5Als Erster einen Block besitzen", true);

    public static ItemStack nether = ItemBuilder.createItem(Material.NETHERRACK, "§aAls Erster den Nether erreichen", false);
    public static ItemStack nether_active = ItemBuilder.createItem(Material.NETHERRACK, "§5Als Erster den Nether erreichen", true);

    public static ItemStack end = ItemBuilder.createItem(Material.END_STONE, "§aAls Erster das End erreichen", false);
    public static ItemStack end_active = ItemBuilder.createItem(Material.END_STONE, "§5Als Erster das End erreichen", true);



    @Override
    public void registerInventory() {


        switch(Config.getGoal()){

            case "mc":
                inv.setItem(10, mc_active);
                inv.setItem(12, block);
                inv.setItem(14, nether);
                inv.setItem(16, end);
                break;
            case "block":
                inv.setItem(10, mc_active);
                inv.setItem(12, block_active);
                inv.setItem(14, nether);
                inv.setItem(16, end);
                break;
            case "nether":
                inv.setItem(10, mc_active);
                inv.setItem(12, block);
                inv.setItem(14, nether_active);
                inv.setItem(16, end);
                break;
            case "end":
                inv.setItem(10, mc_active);
                inv.setItem(12, block);
                inv.setItem(14, nether);
                inv.setItem(16, end_active);
                break;
        }
    }
}
