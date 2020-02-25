package de.craftagain.challengesystem.command;

import de.craftagain.challengesystem.inventory.Inventories;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_challenge implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player)sender;

            if(cmd.getName().equalsIgnoreCase("challenge")){
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("settings") || args[0].equalsIgnoreCase("s")){
                        player.openInventory(Inventories.MENU);

                    }
                    if(args[0].equalsIgnoreCase("stop")){

                    }
                    if(args[0].equalsIgnoreCase("start")){

                    }
                    return true;
                }
            }
        }

        return false;
    }
}
