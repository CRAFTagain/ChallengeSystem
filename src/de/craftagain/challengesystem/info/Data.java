package de.craftagain.challengesystem.info;

import org.bukkit.Bukkit;

public class Data {

    private static String prefix = "§7[§aChallengeSystem§7]";
    private static String name = "§aChallengeSystem";
    private static String version = "V0.1-Alpha";

    public static String getPrefix() {
        return prefix;
    }

    public static String getName() {
        return name;
    }

    public static String getVersion() {
        return version;
    }

    public static void log(String msg){
        Bukkit.getConsoleSender().sendMessage(getPrefix() + msg);
    }
}
