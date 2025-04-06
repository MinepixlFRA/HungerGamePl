package fr.minepixl.hungerGame.Commands;

import fr.minepixl.hungerGame.Utils.Lobby;
import fr.minepixl.hungerGame.Utils.SignHgClass;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TestCmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String cmd, @NotNull String @NotNull [] args) {
        SignHgClass.updateAll();
        return false;
    }
}
