package fr.minepixl.hungerGame.Utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

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
        this.max_player = 6;
        this.players_counter = 0;
        this.ranked = false;
        this.status = "a changer";
        instance_counter++;
    }

    public void join(Player player) {
        if (loc_room == null) return;
        players_counter++;
        players.add(player);
        player.teleport(loc_room);
    }

    public void quit(Player player) {
        players_counter--;
        players.remove(player);
        player.setHealth(0);
    }

    public int getId() {return this.id;}
    public ArrayList<Player> getPlayers() {return this.players;}
    public void setLoc_room(Location argLoc) {this.loc_room = argLoc;}

    public static ArrayList<Lobby> getInstance_list() {return instance_list;}
}
