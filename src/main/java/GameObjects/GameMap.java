package GameObjects;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMap {
    private ArrayList<Room> mapRooms;
   // private Player player;
 //   private Room activeRoom;
 //   private Room otherRoom;
    private boolean available;
    private int mapID;
    private static HashMap<String,Player> players;

    private HashMap<String,Room> activeRooms;
    private HashMap<String,Room> otherRooms;

    public GameMap(){
        mapRooms = new ArrayList<>();
        players = new HashMap<>();
   //     player = new Player();
    //    activeRoom = null;
    //    otherRoom = null;
        activeRooms = new HashMap<>();
        otherRooms = new HashMap<>();

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
     //   if (activeRoom == null)
       //     activeRoom = mapRooms.get(0);
    }

    public void addPlayer(String playerID){
        Player player = new Player(playerID);
        player.addPlayerItem(new Gold());
        activeRooms.put(playerID,getRandomRoom());
        players.put(playerID,player);
    }

    private Room getRandomRoom(){
        int randomRoomNumber = (int) (Math.random() * (mapRooms.size() - 2 + 1) + 1);
        return mapRooms.get(randomRoomNumber);
    }

    public Player getPlayer(String playerID){
        System.out.println(players.size()+" playing an is "+players.get(playerID)==null);
        return players.get(playerID);
    }




    /*
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

     */


    public Room getActiveRoom(String playerID) {
        return activeRooms.get(playerID);
    }

    public void setActiveRoom(Room activeRoom,String playerID) {
        this.activeRooms.put(playerID,activeRoom);
    }

    public Room getOtherRoom(String playerID) {
        return otherRooms.get(playerID);
    }

    public void setOtherRoom(Room otherRoom,String playerID) {
        this.otherRooms.put(playerID,otherRoom);
    }

    public MapSite getFacingMapSite(String playerID){//String playerName){
   //     Direction playerDirection = players.get(playerName).getFacingDirection();
        Direction playerDirection = getFacingDirection(playerID);
        return activeRooms.get(playerID).getSide(playerDirection);
    }

    public Direction getFacingDirection(String playerID){
        return players.get(playerID).getFacingDirection();
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
