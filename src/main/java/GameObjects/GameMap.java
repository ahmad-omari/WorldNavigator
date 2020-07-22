package GameObjects;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMap {
    private ArrayList<Room> mapRooms;
    private Player player;
    private Room activeRoom;
    private Room otherRoom;
    private boolean available;
    private int mapID;
 //   private HashMap<String,Player> players;

    public GameMap(){
        mapRooms = new ArrayList<>();
  //      players = new HashMap<>();
   //     player = new Player();
        activeRoom = null;
        otherRoom = null;
        available = true;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void addRoom(Room room){
        mapRooms.add(room);
        if (activeRoom == null)
            activeRoom = mapRooms.get(0);
    }
/*
    public void addPlayer(String playerName){
        Player player = new Player(playerName);
        players.put(playerName,player);
    }

    public Player getPlayer(String playerName){
        return players.get(playerName);
    }

 */

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public Room getActiveRoom() {
        return activeRoom;
    }

    public void setActiveRoom(Room activeRoom) {
        this.activeRoom = activeRoom;
    }

    public Room getOtherRoom() {
        return otherRoom;
    }

    public void setOtherRoom(Room otherRoom) {
        this.otherRoom = otherRoom;
    }

    public MapSite getFacingMapSite(){//String playerName){
   //     Direction playerDirection = players.get(playerName).getFacingDirection();
        Direction playerDirection = player.getFacingDirection();
        return activeRoom.getSide(playerDirection);
    }

    public Room roomNo(int roomNumber )
    {
        for( Room room : mapRooms )
        {
            if( room.getRoomNumber( ) == roomNumber )
            {
                return room;
            }
        }
        return null;
    }

    public int getRoomsNumber(){return mapRooms.size();}

    @Override
    public String toString() {
        return "Game Map";
    }
}
