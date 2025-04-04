package fr.minepixl.hungerGame.Commands;

import fr.minepixl.hungerGame.Utils.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SetLocCmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String cmd, @NotNull String @NotNull [] args) {
        if (!(sender instanceof final Player player)) return false;
        if (args.length == 0) return false;
        ArrayList<Lobby> lobby_list = Lobby.getInstance_list();
        if (lobby_list.get(Integer.parseInt(args[0])) == null) {return false;}
        Lobby lobby = lobby_list.get(Integer.parseInt(args[0]));
        lobby.setLoc_room(player.getLocation());
        player.sendMessage("La localisation du lobby " + lobby.getId() + " a été mis a " + player.getLocation());
        return false;
    }
}
