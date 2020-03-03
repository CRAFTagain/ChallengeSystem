package de.craftagain.challengesystem;

import de.craftagain.challengesystem.command.CMD_challenge;
import de.craftagain.challengesystem.event.GoalClickListener;
import de.craftagain.challengesystem.event.MenuClickListener;
import de.craftagain.challengesystem.event.TimerClickListener;
import de.craftagain.challengesystem.info.Data;
import de.craftagain.challengesystem.inventory.IInventory;
import de.craftagain.challengesystem.inventory.INV_Goals;
import de.craftagain.challengesystem.inventory.INV_Menu;
import de.craftagain.challengesystem.inventory.INV_Timer;
import de.craftagain.challengesystem.utils.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class ChallengeSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        Data.log("System started");

        //Inventories
        new INV_Menu().registerInventory();
        new INV_Goals().registerInventory();
        new INV_Timer().registerInventory();

        //Commands
        getCommand("challenge").setExecutor(new CMD_challenge());

        //Events
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new MenuClickListener(), this);
        pm.registerEvents(new GoalClickListener(), this);
        pm.registerEvents(new TimerClickListener(), this);

        //Config
        try {
            Config.save();
            Config.setGoal("mc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        Data.log("System stopped");
    }
}
