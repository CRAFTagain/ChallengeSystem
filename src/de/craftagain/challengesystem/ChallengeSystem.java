package de.craftagain.challengesystem;

import de.craftagain.challengesystem.command.CMD_settings;
import de.craftagain.challengesystem.command.CMD_timer;
import de.craftagain.challengesystem.event.*;
import de.craftagain.challengesystem.info.Data;
import de.craftagain.challengesystem.inventory.*;
import de.craftagain.challengesystem.utils.config.Config;
import de.craftagain.challengesystem.utils.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class ChallengeSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        Data.log("System started");
        new Timer().stop();


        //Config
        try {
            Config.save();
            Config.setGoal("mc");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Inventories
        new INV_Menu().registerInventory();
        new INV_Goals().registerInventory();
        new INV_Timer().registerInventory();
        new INV_CountDownSettings().registerInventory();
        new INV_CountUpSettings().registerInventory();

        //Commands
        getCommand("settings").setExecutor(new CMD_settings());
        getCommand("timer").setExecutor(new CMD_timer());

        //Events
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new MenuClickListener(), this);
        pm.registerEvents(new GoalClickListener(), this);
        pm.registerEvents(new TimerClickListener(), this);
        pm.registerEvents(new CountDownSettingsClickListener(), this);
        pm.registerEvents(new CountUpSettingsClickListener(), this);


    }

    @Override
    public void onDisable() {
        Data.log("System stopped");
    }
}
