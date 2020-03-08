package de.craftagain.challengesystem.command;

import de.craftagain.challengesystem.utils.config.Config;
import de.craftagain.challengesystem.utils.timer.Timer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_timer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player)sender;

            if(cmd.getName().equalsIgnoreCase("timer")){
                if(args.length != 1)
                    return false;
                if(args[0].equalsIgnoreCase("resume")){
                    if(Config.config.getString("Timer.type").equals("count_up")){
                        new Timer().countUp();
                    }
                    if(Config.config.getString("Timer.type").equals("count_down")){
                        new Timer().countDown();
                    }

                }
                if(args[0].equalsIgnoreCase("stop")){
                        new Timer().stop();
                }
                return true;

            }
        }

        return false;
    }
}
