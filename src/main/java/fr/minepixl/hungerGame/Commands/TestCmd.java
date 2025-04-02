package fr.minepixl.hungerGame.Commands;

import fr.minepixl.hungerGame.Utils.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TestCmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String cmd, @NotNull String @NotNull [] args) {
        sender.sendMessage(String.valueOf(Lobby.getInstance_list()));
        sender.sendMessage(Lobby.getInstance_list().toArray().length + " lobby ont été créés.");
        return false;
    }
}
