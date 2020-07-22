package GameObjects;

public class Map implements MapLoader{
    private MapFactory mapFactory;
    private GameMap gameMap;
    private MapConfiguration configuration;

    public Map(){
        configuration = new MapConfiguration();
    }
    @Override
    public GameMap createMap(MapFactory mapFactory) {
        gameMap = mapFactory.makeMap();
        this.mapFactory = mapFactory;
        addRooms();
        return gameMap;
    }

    private void addRooms() {
        int specialDoorsMin = configuration.getMinNumberOfSpecialDoors();
        int specialDoorsMax = configuration.getMaxNumberOfSpecialDoors();
        int roomMax = configuration.getMaxNumberOfRooms();
        int roomMin = configuration.getMinNumberOfRooms();
        int numberOfRooms = (int) (Math.random() * (roomMax - roomMin + 1) + roomMin);
        int numberOfSpecialDoors = (int) (Math.random() * (specialDoorsMax - specialDoorsMin + 1) + specialDoorsMin);

        for (int i=1 ; i<=numberOfRooms ; i++){
            Room room = mapFactory.makeRoom(i);
            room.setSide(Direction.WEST, getRandomSite());
            room.setSide(Direction.SOUTH, getRandomSite());
            room.setSide(Direction.EAST, getRandomSite());
            room.setSide(Direction.NORTH, getRandomSite());
            gameMap.addRoom(room);
        }

        for (int i=1 ; i<numberOfRooms ; i++){
            Room room1 = gameMap.roomNo(i);
            Room room2 = gameMap.roomNo(i+1);
            Door door = mapFactory.makeDoor(room1,room2);
            gameMap.roomNo(i).setSide(Direction.NORTH,door);
        }

        SpecialDoor door = (SpecialDoor) mapFactory.makeSpecialDoor(gameMap.roomNo(numberOfRooms));
        Key key = getRandomKey();
        if (!key.getITEM_NAME().equals(new EmptyItem().getITEM_NAME()))
            door.setDoorKey(key);
        gameMap.roomNo(numberOfRooms).setSide(Direction.NORTH, door);

        for (int i=1 ; i<numberOfSpecialDoors ; i++){
            int roomsNumber = (int) (Math.random() * (roomMax - roomMin + 1) + roomMin-1);
            SpecialDoor specialDoor = (SpecialDoor) mapFactory.makeSpecialDoor(gameMap.roomNo(roomsNumber));
            Key key1 = getRandomKey();
            if (!key1.getITEM_NAME().equals(new EmptyItem().getITEM_NAME()))
                specialDoor.setDoorKey(key1);
            gameMap.roomNo(roomsNumber).setSide(Direction.NORTH, specialDoor);
        }

    }

    private Key getRandomKey(){
        int randomNumber = (int) (Math.random() * (3 - 1 + 1) + 1);
        switch (randomNumber){
            case 1:return new SilverKey();
            case 2:return new GoldenKey();
            case 3:return new MagicKey();
            default:return new EmptyKey();
        }
    }

    private Mirror makeRandomlyMirror(){
        Mirror mirror = new Mirror();
        if (getRandomChoice()){
            Key key = getRandomKey();
            if (!key.getITEM_NAME().equals(new EmptyItem().getITEM_NAME()))
                mirror.setKey(key);
        }
        return mirror;
    }

    private Chest makeRandomlyChest(){
        Chest chest = new Chest();
        if (getRandomChoice()){
            Key key = getRandomKey();
            if (!key.getITEM_NAME().equals(new EmptyItem().getITEM_NAME()))
                chest.addChestItem(key);
        }
        if (getRandomChoice()){
            chest.addChestItem(new FlashLight());
        }
        return chest;
    }

    private Painting makeRandomlyPainting(){
        Painting painting = new Painting();
        if (getRandomChoice()){
            Key key = getRandomKey();
            if (!key.getITEM_NAME().equals(new EmptyItem().getITEM_NAME()))
                painting.setKey(key);
        }
        return painting;
    }

    private Seller makeRandomlySeller(){
        Seller seller = new Seller();
        int randomNumber = (int) (Math.random() * (3 - 1 + 1) + 1);
        for (int i=1;i<=randomNumber;i++) {
            if (getRandomChoice()) {
                Key key = getRandomKey();
                if (!key.getITEM_NAME().equals(new EmptyItem().getITEM_NAME()))
                    seller.addSellerItem(key);
            }
        }
        if (getRandomChoice()){
            seller.addSellerItem(new FlashLight());
        }
        return seller;
    }

    private MapSite getRandomSite(){
        int randomNumber = (int) (Math.random() * (5 - 1 + 1) + 1);
        MapSite site = new PlainWall();
        switch (randomNumber){
            case 2:
                site = makeRandomlyMirror();
                break;
            case 3:
                site = makeRandomlyChest();
                break;
            case 4:
                site = makeRandomlySeller();
                break;
            case 5:
                site = makeRandomlyPainting();
                break;
        }
        return site;
    }

    private boolean getRandomChoice(){
        int randomNumber = (int) (Math.random() * (2 - 1 + 1) + 1);
        switch (randomNumber){
            case 1:return false;
            case 2:return true;
            default:return false;
        }
    }

    @Override
    public String toString() {
        return "Game Map ...";
    }

    @Override
    public void load() {
        System.out.println("Loading map ...");
    }
}
