package fr.minepixl.hungerGame.Commands;

import fr.minepixl.hungerGame.Utils.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CreateCmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String cmd, @NotNull String @NotNull [] args) {
        Lobby lobby = new Lobby();
        sender.sendMessage("Le lobby %d a été créé avec succes".formatted(lobby.getId()));
        return false;
    }
}
