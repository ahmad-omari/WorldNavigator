package GameObjects;

public class Look implements Command{
    GameMap map;

    public Look(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Room room = map.getActiveRoom();
        Light light = room.getRoomLight();
        if (light != null && light.isLightON())
            map.getFacingMapSite().look();
        else
            System.out.println("Dark");
    }

    @Override
    public String toString() {
        return "Look";
    }
}
