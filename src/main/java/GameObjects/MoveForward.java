package GameObjects;

public class MoveForward implements Command {
    private GameMap map;

    public MoveForward(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        MapSite doorSite = map.getFacingMapSite();
        if (doorSite instanceof Door){
            Door door = (Door) doorSite;
            Room currentRoom = door.getCurrentRoom();
            Room nextRoom = door.getNextRoomFrom(currentRoom);
            if (door.isOpen()){
                if (door instanceof SpecialDoor) {
                    GameStatus status = GameStatus.getInstance();
                    status.setPlaying(false);
                    System.out.println("\nYou win");
                }else {
                    map.setActiveRoom(nextRoom);
                    map.setOtherRoom(currentRoom);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Move Forward command";
    }
}
