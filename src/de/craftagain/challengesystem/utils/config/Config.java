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

}
