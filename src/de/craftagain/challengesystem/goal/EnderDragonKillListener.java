package de.craftagain.challengesystem.goal;

import de.craftagain.challengesystem.utils.config.Config;
import de.craftagain.challengesystem.utils.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnderDragonKillListener implements Listener {

    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent event){

            if(Config.getGoal().equals("mc")){
                if(event.getEntity() instanceof  EnderDragon){
                    for(Player player : Bukkit.getOnlinePlayers()){
                        player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 100, 1);
                        player.sendMessage("§7-> §8Der §5Enderdrache §8ist §5gefallen§8!");
                        player.sendMessage(" ");
                        player.sendMessage("§7-> §6§lDie Challenge wurde erfolgreich beendet!");
                        player.sendMessage(" ");
                        if(Config.getTimerType().equals("count_up")) {
                            player.sendMessage("§7-> §8Benötigte Zeit: §6" + new Timer().hours + ":" + new Timer().minutes + ":" + new Timer().seconds);
                        }else
                            player.sendMessage("§7-> §8Die Zeit wurde bei §6" + new Timer().hours + ":" + new Timer().minutes + ":" + new Timer().seconds + " §8pausiert");

                        new Timer().stop();
                    }
                }
        }

    }

}
