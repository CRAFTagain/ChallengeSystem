package de.craftagain.challengesystem.command;

import de.craftagain.challengesystem.inventory.Inventories;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_settings implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("settings")) {
                if(args.length != 0)
                    return false;
                player.openInventory(Inventories.MENU);
                return true;
            }
        }


        return false;
    }
}
