package fr.minepixl.hungerGame;

import fr.minepixl.hungerGame.Event.EventClass;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();
        getLogger().info(ChatColor.GREEN + "Le plugin démarre !");
        instance = this;
        getServer().getPluginManager().registerEvents(new EventClass(), instance);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info(ChatColor.DARK_RED + "Le plugin s'arrete.");
    }

    public static Main getInstance() {
        return instance;
    }
}
