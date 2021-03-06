package de.craftagain.challengesystem.utils.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    //Config file
    private static File file = new File("plugins/ChallengeSystem", "Config.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    //Save method
    public static void save() throws IOException {
        config.save(file);
    }

    public static void setGoal(String goal) throws IOException {
        config.set("Challenge.goal", goal);
        save();
    }

    public static String getGoal(){
        return config.getString("Challenge.goal");
    }

    public static void setTimer(int hours, int minutes, int seconds) throws IOException {
        config.set("Timer.time.hours", hours);
        config.set("Timer.time.minutes", minutes);
        config.set("Timer.time.seconds", seconds);

        save();
    }
    public static void setTimerType(String timerType) throws IOException {
        config.set("Timer.type", timerType);
        save();
    }
    public static String getTimerType(){
        return config.getString("Timer.type");
    }

}
