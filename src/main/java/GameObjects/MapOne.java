package GameObjects;

public class MapOne implements MapLoader{
    private MapFactory mapFactory;
    private GameMap gameMap;
    public GameMap createMap(MapFactory mapFactory){
        gameMap = mapFactory.makeMap();
        this.mapFactory = mapFactory;
        addPlayer();
        addRooms();
        return gameMap;
    }

    private void addPlayer(){
       // Player player = mapFactory.makePlayer();
       // player.addPlayerItem(new Gold());
       // gameMap.setPlayer(player);
    }
    private void addRooms(){
        Room room1 = mapFactory.makeRoom(1);
        Room room2 = mapFactory.makeRoom(2);
        Door door1 = mapFactory.makeDoor(room1,room2);
        Door door2 = mapFactory.makeSpecialDoor(room2);
        room1.setSide(Direction.WEST, new PlainWall());
        room1.setSide(Direction.SOUTH, new PlainWall());
        room1.setSide(Direction.EAST, door1);
        room1.setSide(Direction.NORTH, new PlainWall());
        room1.setRoomLight(new Light());
        room2.setSide(Direction.WEST, new PlainWall());
        room2.setSide(Direction.SOUTH, new PlainWall());
        room2.setSide(Direction.EAST, new PlainWall());
        room2.setSide(Direction.NORTH, door2);
        room2.setRoomLight(new Light());
        gameMap.addRoom(room1);
        gameMap.addRoom(room2);
    }

    @Override
    public String toString() {
        return "Game Map 1";
    }

    @Override
    public void load() {
        System.out.println("Loading map 1 ...");
    }
}
