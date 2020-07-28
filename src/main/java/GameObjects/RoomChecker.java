package GameObjects;

import java.util.Iterator;
import java.util.Map;

public class RoomChecker {
    private GameMap gameMap;
    public RoomChecker(GameMap gameMap){
        this.gameMap = gameMap;
    }

    public String getBusyPlayerID(Room room,String playerID){
        Iterator iterator = gameMap.getActiveRooms().entrySet().iterator();
        while (iterator.hasNext()){
            java.util.Map.Entry pair = (Map.Entry) iterator.next();
            Room playerRoom = (Room) pair.getValue();
            if (playerRoom.getRoomNumber()==room.getRoomNumber() && (!pair.getKey().equals(playerID))){
                return pair.getKey().toString();
            }
        }
        return "not found";
    }
}
