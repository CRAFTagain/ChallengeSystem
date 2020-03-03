package de.craftagain.challengesystem.inventory;

import de.craftagain.challengesystem.api.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class INV_Timer implements IInventory {

    private Inventory inv = Inventories.TIMER;

    public static ItemStack count_up = ItemBuilder.createItem(Material.PLAYER_HEAD, "§aHochzählend", false);
    public static ItemStack count_up_active = ItemBuilder.createItem(Material.PLAYER_HEAD, "§5Hochzählend", false);

    public static ItemStack count_down = ItemBuilder.createItem(Material.PLAYER_HEAD, "§aRunterzählend", false);
    public static ItemStack count_down_active = ItemBuilder.createItem(Material.PLAYER_HEAD, "§5Runterzählend", false);




    @Override
    public void registerInventory() {

        SkullMeta metaUp = (SkullMeta) count_up.getItemMeta();
        metaUp.setOwner("MHF_ArrowUp");
        count_up.setItemMeta(metaUp);

        SkullMeta metaUpActive = (SkullMeta) count_up_active.getItemMeta();
        metaUpActive.setOwner("MHF_ArrowUp");
        count_up_active.setItemMeta(metaUpActive);

        SkullMeta metaDown = (SkullMeta) count_down.getItemMeta();
        metaDown.setOwner("MHF_ArrowDown");
        count_down.setItemMeta(metaDown);

        SkullMeta metaDownActive = (SkullMeta) count_down_active.getItemMeta();
        metaDownActive.setOwner("MHF_ArrowDown");
        count_down_active.setItemMeta(metaDownActive);


        inv.setItem(11, count_up);
        inv.setItem(15, count_down);

    }
}
