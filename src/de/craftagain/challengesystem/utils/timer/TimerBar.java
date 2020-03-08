package de.craftagain.challengesystem.utils.timer;

import de.craftagain.challengesystem.ChallengeSystem;
import de.craftagain.challengesystem.utils.config.Config;
import net.minecraft.server.v1_14_R1.ChatMessageType;
import net.minecraft.server.v1_14_R1.IChatBaseComponent;
import net.minecraft.server.v1_14_R1.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TimerBar {

    public void sendTimerBar(Player player, String msg){
        IChatBaseComponent iChat = IChatBaseComponent.ChatSerializer.a("{\"text\":\"\"}").a(msg);
        PacketPlayOutChat packet = new PacketPlayOutChat(iChat, ChatMessageType.GAME_INFO);

        CraftPlayer craftPlayer = (CraftPlayer)player;
        craftPlayer.getHandle().playerConnection.sendPacket(packet);
    }


}
