package GameObjects;

public class OpenDoor implements Command {
    private GameMap map;

    public OpenDoor(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        MapSite doorSite = map.getFacingMapSite();
        if (doorSite instanceof Door){
            Key key = ((Door) doorSite).getDoorKey();
            if (key == null) {
                System.out.println("Door opened");
                ((Door) doorSite).setDoorOpen(true);
            }else {
                if (((Door) doorSite).isOpen())
                    System.out.println("Door opened");
                else
                    System.out.println("The "+key.getITEM_NAME()+" required to unlock");
            }
        }
    }

    @Override
    public String toString() {
        return "Open Door command";
    }
}
