package de.craftagain.challengesystem.api;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public static ItemStack createItem(Material mat, String name, boolean isEnchanted){

        ItemStack stack = new ItemStack(mat);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);

        if(isEnchanted){
            meta.addEnchant(Enchantment.DURABILITY, 0 , true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        stack.setItemMeta(meta);

        return stack;
    }

}
