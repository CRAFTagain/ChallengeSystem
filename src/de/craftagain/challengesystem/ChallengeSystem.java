package de.craftagain.challengesystem;

import de.craftagain.challengesystem.command.CMD_challenge;
import de.craftagain.challengesystem.info.Data;
import de.craftagain.challengesystem.inventory.IInventory;
import de.craftagain.challengesystem.inventory.INV_Menu;
import org.bukkit.plugin.java.JavaPlugin;

public class ChallengeSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        Data.log("System started");

        new INV_Menu().registerInventory();

        getCommand("challenge").setExecutor(new CMD_challenge());


    }

    @Override
    public void onDisable() {
        Data.log("System stopped");
    }
}