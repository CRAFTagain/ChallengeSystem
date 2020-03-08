package de.craftagain.challengesystem.utils.timer;

import de.craftagain.challengesystem.ChallengeSystem;
import de.craftagain.challengesystem.utils.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Timer {

    private ChallengeSystem plugin = ChallengeSystem.getPlugin(ChallengeSystem.class);

    public int hours;
    public int minutes;
    public int seconds;

    public void countDown(){
        Bukkit.getScheduler().cancelTasks(plugin);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            try {
                removeTime(0, 0, 1);
                if(hours == 0 && minutes == 0 && seconds == 0){
                    stop();
                }
                for(Player player : Bukkit.getOnlinePlayers()) {
                    new TimerBar().sendTimerBar(player, "§4In der Challenge §7| §6§l" + hours + " §7: §6§l" + minutes + " §7: §6§l" + seconds);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 20);
    }

    public void countUp(){
        Bukkit.getScheduler().cancelTasks(plugin);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
                try {
                    addTime(0, 0, 1);
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        new TimerBar().sendTimerBar(player, "§4In der Challenge §7| §6§l" + hours + " §7: §6§l" + minutes + " §7: §6§l" + seconds);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        },0 ,20);
    }

    public void addTime(int h, int m, int s) throws IOException {

        hours = Config.config.getInt("Timer.time.hours");
        minutes = Config.config.getInt("Timer.time.minutes");
        seconds = Config.config.getInt("Timer.time.seconds");

        seconds += s;

        while(seconds > 59) {
            seconds -= 60;
            minutes++;
        }

        minutes += m;

        while(minutes > 59) {
            minutes -= 60;
            hours++;
        }
            Config.setTimer(hours, minutes, seconds);



    }
    public void removeTime(int h, int m, int s) throws IOException {
        hours = Config.config.getInt("Timer.time.hours");
        minutes = Config.config.getInt("Timer.time.minutes");
        seconds = Config.config.getInt("Timer.time.seconds");

        seconds -= s;
        while(seconds < 0) {
            minutes--;
            seconds += 60;
        }
        minutes -= m;

        while(minutes < 0) {
            if(!(hours <= 0)){
                hours--;
                minutes += 60;

            }else {
                hours = 0;
                minutes = 0;
                seconds = 0;
            }
        }

            Config.setTimer(hours, minutes, seconds);
    }

    public void stop(){
        Bukkit.getScheduler().cancelTasks(plugin);
        pause();
    }

    private void pause(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            hours = Config.config.getInt("Timer.time.hours");
            minutes = Config.config.getInt("Timer.time.minutes");
            seconds = Config.config.getInt("Timer.time.seconds");

            for(Player player : Bukkit.getOnlinePlayers()){
                new TimerBar().sendTimerBar(player, "§7§oTimer ist pausiert -> " + hours + ":" + minutes + ":" + seconds);
            }
        },0, 20);
    }
}
