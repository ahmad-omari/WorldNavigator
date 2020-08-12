package GameObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GameMap {
    private ArrayList<Room> mapRooms;
    private GameTimer timer;
    private  boolean available;
    private int mapID;
    private static HashMap<String,Player> players = new HashMap<>();
    private HashMap<String,Room> activeRooms;
    private HashMap<String,Room> otherRooms;
    private String winnerName;
    private boolean closed;

    public GameMap(){
        mapRooms = new ArrayList<>();
        activeRooms = new HashMap<>();
        otherRooms = new HashMap<>();
        available = true;
        closed = false;
        startTimer();
    }

    private void startTimer() {
        timer = new GameTimer();
        timer.setTimeInMinutes(120);
        timer.start();
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
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

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public void addRoom(Room room){
        mapRooms.add(room);
    }

    public void addPlayer(String playerID){
        Player player = new Player(playerID);
        player.addPlayerItem(new Gold());
        activeRooms.put(playerID,getRandomRoom());
        players.put(playerID,player);
    }

    public Player getPlayer(String playerID){
        System.out.println(players.size()+" playing an is "+players.get(playerID)==null);
        return players.get(playerID);
    }

    public int getPlayersNumber(){
        return players.size();
    }

    public Iterator getPlayersIterator(){
        return players.entrySet().iterator();
    }

    public HashMap<String, Room> getActiveRooms() {
        return activeRooms;
    }

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

    public MapSite getFacingMapSite(String playerID){
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

    private Room getRandomRoom(){
        int randomRoomNumber = (int) (Math.random() * (mapRooms.size() - 2 + 1) + 1);
        return mapRooms.get(randomRoomNumber);
    }

    @Override
    public String toString() {
        return "Game Map";
    }
}
