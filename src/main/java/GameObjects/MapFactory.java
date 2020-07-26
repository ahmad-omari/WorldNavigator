package GameObjects;

public class MapFactory {
    public GameMap makeMap(){return new GameMap();}
    public Room makeRoom(int roomNumber){return new Room(roomNumber);}
    public Player makePlayer(String playerID){return new Player(playerID);}
    public Door makeDoor(Room room1, Room room2){return new Door(room1,room2);}
    public Door makeSpecialDoor(Room room){return new SpecialDoor(room);}

    @Override
    public String toString() {
        return "Map factory";
    }
}
