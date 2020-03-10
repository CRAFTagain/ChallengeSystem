package de.craftagain.challengesystem.goal;

import de.craftagain.challengesystem.utils.config.Config;
import de.craftagain.challengesystem.utils.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class DimensionEnterListener implements Listener {

    private int i = 0;
    private int j = 0;

    @EventHandler
    public void onNetherEnter(PlayerMoveEvent event){

        if(Config.getGoal().equals("nether")) {
            if (event.getPlayer().getLocation().getWorld().getName().endsWith("_nether")) {
                    if(i == 0) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 100, 1);
                            player.sendMessage("§7-> §8Der §4Nether §8wurde von §4" + event.getPlayer() + "§8betreten!");
                            player.sendMessage(" ");
                            player.sendMessage("§7-> §6§lDie Challenge wurde erfolgreich beendet!");
                            player.sendMessage(" ");
                            if (Config.getTimerType().equals("count_up")) {
                                player.sendMessage("§7-> §8Benötigte Zeit: §6" + new Timer().hours + ":" + new Timer().minutes + ":" + new Timer().seconds);
                            } else
                                player.sendMessage("§7-> §8Die Zeit wurde bei §6" + new Timer().hours + ":" + new Timer().minutes + ":" + new Timer().seconds + " §8pausiert");

                            new Timer().stop();
                        }
                    }
                    i++;
            }
        }
    }

    @EventHandler
    public void onEndEnter(PlayerMoveEvent event){

        if(Config.getGoal().equals("end")) {
            if (event.getPlayer().getLocation().getWorld().getName().endsWith("_end")) {
                if(j == 0) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 100, 1);
                        player.sendMessage("§7-> §8Das §5End §8wurde von §5" + event.getPlayer() + "§8betreten!");
                        player.sendMessage(" ");
                        player.sendMessage("§7-> §6§lDie Challenge wurde erfolgreich beendet!");
                        player.sendMessage(" ");
                        if (Config.getTimerType().equals("count_up")) {
                            player.sendMessage("§7-> §8Benötigte Zeit: §6" + new Timer().hours + ":" + new Timer().minutes + ":" + new Timer().seconds);
                        } else
                            player.sendMessage("§7-> §8Die Zeit wurde bei §6" + new Timer().hours + ":" + new Timer().minutes + ":" + new Timer().seconds + " §8pausiert");

                        new Timer().stop();
                    }
                }
                j++;
            }
        }
    }

}
