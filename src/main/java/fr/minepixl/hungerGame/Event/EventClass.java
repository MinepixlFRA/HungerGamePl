package fr.minepixl.hungerGame.Event;

import fr.minepixl.hungerGame.Utils.SignHgClass;
import io.papermc.paper.event.player.PlayerOpenSignEvent;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventClass implements Listener {
    @EventHandler
    public void createHgSign(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;
        if (!(event.getClickedBlock().getState() instanceof final Sign sign)) return;
        if (!(sign.getSide(Side.FRONT).getLine(0).equalsIgnoreCase("[hgames]"))) return;
        if (!(event.getPlayer().hasPermission("hg.sign.create"))) return;
        sign.getSide(Side.FRONT).setLine(0, "§f> §bClick to join §f<");
        sign.getSide(Side.FRONT).setLine(1, "§bHunger Games");
        sign.getSide(Side.FRONT).setLine(2, "§r§b0 §l§f/ §r§b6 players");
        sign.getSide(Side.FRONT).setLine(3, "§l§f---------------");
        sign.getSide(Side.FRONT).setGlowingText(false);
        sign.update();
        SignHgClass.instances.put(sign.getLocation(), SignHgClass.instances_count);
        SignHgClass.instances_count++;
        event.getPlayer().sendMessage("------------------------");
        event.getPlayer().sendMessage(String.valueOf(SignHgClass.instances));
        event.getPlayer().sendMessage("------------------------");
    }

    @EventHandler
    public void deleteHgSign(BlockBreakEvent event) {
        if (!(event.getBlock().getState() instanceof Sign)) return;
        if (event.getPlayer().hasPermission("hg.sign.create")) {
            if (SignHgClass.instances.containsKey(event.getBlock().getLocation())) {
                SignHgClass.instances.remove(event.getBlock().getLocation());
                event.getPlayer().sendMessage("------------------------");
                event.getPlayer().sendMessage(String.valueOf(SignHgClass.instances));
                event.getPlayer().sendMessage("------------------------");
            }
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void cancelSignEdit(PlayerOpenSignEvent event) {
        if (event.getSign().getSide(Side.FRONT).getLine(0).equalsIgnoreCase("[hgames]") || event.getSign().getSide(Side.FRONT).getLine(0).equalsIgnoreCase("§f> §bClick to join §f<")) {
            if (event.getPlayer().hasPermission("hg.sign.create")) {
                event.setCancelled(true);
            }
        }
    }
}
