package commands;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Start_FightCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        Player p = (Player) sender;
        Player p1 = Bukkit.getPlayer(args[0]);
        Player p2 = Bukkit.getPlayer(args[1]);
        Location loc_p1 = new Location(p.getWorld(),-8, -59, 8, -90, 1);
        Location loc_p2 = new Location(p.getWorld(), 7, -59, 8, 90, 1);

//
        assert p1 != null;
        assert p2 != null;
        p1.teleport(loc_p1);
        p2.teleport(loc_p2);

        if(p.isOp()){
            for(Player player : Bukkit.getOnlinePlayers()){
                player.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.YELLOW + args[0] + " vs " + args[1]));
            }
            return true;
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        List<String> complete = new ArrayList<>();
        Player p = (Player)sender;


        if(p.isOp()){
            if(args.length == 1){
                for(Player player : Bukkit.getOnlinePlayers()){
                    complete.add(player.getName());
                }
            }
        }
        return complete;
    }
}
