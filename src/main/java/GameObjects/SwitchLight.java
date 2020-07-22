package GameObjects;

public class SwitchLight implements Command {
    private GameMap map;

    public SwitchLight(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Room room = map.getActiveRoom();
        if (room.hasLight())
            room.getRoomLight().switchLight();
    }

    @Override
    public String toString() {
        return "Switch Light command";
    }
}
