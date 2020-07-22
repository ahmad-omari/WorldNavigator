package GameObjects;

public class Room {
    private MapSite [] sides;
    private Light roomLight;
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;

        sides = new MapSite[4];
        roomLight = null;
    }

    public void setSide(Direction direction, MapSite site){
        sides[direction.ordinal()] = site;
    }

    public MapSite getSide(Direction direction){
        return sides[direction.ordinal()];
    }

    public Light getRoomLight() {
        return roomLight;
    }

    public void setRoomLight(Light roomLight) {
        this.roomLight = roomLight;
    }

    public boolean hasLight(){return roomLight != null;}

    public int getRoomNumber()
    {
        return roomNumber;
    }

    private void setRoomNumber( int roomNumber )
    {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Room";
    }
}
