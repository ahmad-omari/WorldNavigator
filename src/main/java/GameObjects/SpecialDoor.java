package GameObjects;

public class SpecialDoor extends Door {
    public SpecialDoor(Room currentRoom) {
        super(currentRoom, new Room(0));
    }

    @Override
    public String toString() {
        return "Special Door";
    }
}
