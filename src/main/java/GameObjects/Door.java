package GameObjects;

public class Door implements MapSite {
    private Room currentRoom;
    private Room nextRoom;
    private Key doorKey;
    private boolean open;

    public Door(Room currentRoom, Room nextRoom) {
        this.currentRoom = currentRoom;
        this.nextRoom = nextRoom;
        doorKey = null;
        open = true;
    }

    public Room getNextRoomFrom(Room room){
        if (room != null){
            if (room.equals(currentRoom))
                return nextRoom;
            if (room.equals(nextRoom))
                return currentRoom;
        }
        return null;
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public void setDoorKey(Key doorKey) {
        this.doorKey = doorKey;
        setDoorOpen(false);
    }

    public Key getDoorKey() {
        return doorKey;
    }

    public void setDoorOpen(boolean doorOpen){
        this.open = doorOpen;
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    public String look() {
        return "You are facing a door";
    }

    @Override
    public String toString() {
        return "Door";
    }
}
