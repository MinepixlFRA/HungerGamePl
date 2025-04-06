package fr.minepixl.hungerGame.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;

import java.util.ArrayList;
import java.util.HashMap;

public class SignHgClass {
    public static int instances_count = 0;
    public static HashMap<Location, Integer> instances = new HashMap<>();

    public static void updateAll() {
        int i = 0;
        for (Location panneauLoc : instances.keySet()) {
            Sign panneau = (Sign) panneauLoc.getBlock().getState();
            panneau.getSide(Side.FRONT).setGlowingText(true);
            panneau.update();
            i++;
        }
        Bukkit.broadcastMessage("Les " + i + " panneaux ont été mis a jour.");
    }
}
