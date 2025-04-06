package fr.minepixl.hungerGame.Utils;

import fr.minepixl.hungerGame.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;

public class Lobby {

    private static int instance_counter = 0;
    private static ArrayList<Lobby> instance_list = new ArrayList<>();

    private int id;
    private String map;
    private int max_player;
    private int players_counter;
    private ArrayList<Player> players = new ArrayList<>();
    private boolean ranked;
    private String status;
    private Location loc_room;

    public Lobby() {
        this.id = instance_counter;
        instance_list.add(this);
        this.map = "a changer";
        this.max_player = 32;
        this.players_counter = 0;
        this.ranked = false;
        this.status = "a changer";
        instance_counter++;
    }

    public void sendMessageLobby(String s) {
        for (Player player : players) {
            player.sendMessage(s);
        }
    }

    public void join(Player player) {
        if (players_counter >= max_player) {
            player.sendMessage("Ce lobby est plein.");
            return;
        }
        if (loc_room == null) return;
        players_counter++;
        players.add(player);
        player.teleport(loc_room);
        whenPlayerJoin();
        player.sendMessage("Vous avez bien rejoin le lobby.");
    }

    public void quit(Player player) {
        if (players.contains(player)) {
            players_counter--;
            players.remove(player);
            player.setHealth(0);
        } else {
            player.sendMessage("vous n'etes pas dans ce lobby");
        }
    }

    public void whenPlayerJoin() {
        if (players_counter == 2) {
            new BukkitRunnable() {
                int i = 60;

                @Override
                public void run() {
                    if (players_counter < 2) {
                        cancel();
                        sendMessageLobby("Annulation du decompte en attandant un deuxieme joueur minimum.");
                        return;
                    }
                    if (i <= 0) {
                        cancel();
                        sendMessageLobby("C'est parti mon kiki !");
                        launch();
                        return;
                    }
                    if ((i == 60) || (i == 45) || (i == 30) || (i == 20) || (i <= 10)) {sendMessageLobby("La partie commence dans " + i + " sec.");}
                    i--;
                }
            }.runTaskTimer(Main.getInstance(), 0L, 20L);
        }
    }

    public void launch() {
        for (Player player : players) {
            player.teleport(new Location(Bukkit.getWorld("world"), -11, 63, -123));
        }
    }

    public int getId() {return this.id;}
    public ArrayList<Player> getPlayers() {return this.players;}
    public void setLoc_room(Location argLoc) {this.loc_room = argLoc;}

    public static ArrayList<Lobby> getInstance_list() {return instance_list;}
}
