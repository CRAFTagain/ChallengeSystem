package de.craftagain.challengesystem.api;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public static ItemStack createItem(ItemStack stack, String name, boolean isEnchanted){

        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);

        if(isEnchanted){
            meta.addEnchant(Enchantment.DURABILITY, 0 , false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        stack.setItemMeta(meta);

        return stack;
    }

}
