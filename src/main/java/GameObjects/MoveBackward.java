package GameObjects;

public class MoveBackward implements Command {
    private GameMap map;

    public MoveBackward(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        MapSite doorSite = map.getFacingMapSite();
        if (doorSite instanceof Door) {
            Door door = (Door) doorSite;
            if (door.isOpen()) {
                Room room = map.getOtherRoom();
                if (room != null)
                    map.setActiveRoom(room);
            }
        }
    }

    @Override
    public String toString() {
        return "Move Backward command";
    }
}
