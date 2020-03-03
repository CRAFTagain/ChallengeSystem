package de.craftagain.challengesystem.inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class Inventories {

    public static Inventory MENU = Bukkit.createInventory(null, 9*5, "§8Einstellungen");
    public static Inventory GOALS = InventoryTemplate.createNewInventory("§8Ziele");
    public static Inventory TIMER = InventoryTemplate.createNewInventory("§8Timer");


}
