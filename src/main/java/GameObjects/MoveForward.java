package GameObjects;

import org.json.simple.JSONObject;

import javax.servlet.http.HttpSession;

public class MoveForward implements Command {
    private GameMap map;

    public MoveForward(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        MapSite doorSite = map.getFacingMapSite(playerID);
        if (doorSite instanceof Door){
            Door door = (Door) doorSite;
            Room currentRoom = door.getCurrentRoom();
            Room nextRoom = door.getNextRoomFrom(currentRoom);
            if (door.isOpen()){
                if (door instanceof SpecialDoor) {
                    GameStatus status = GameStatus.getInstance();
                    status.setPlaying(false);
                    System.out.println("\nYou win");
                    JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
                    map.setWinnerName(playerID);
                    jsonObject.put("result","finished");
                }else {
                    map.setActiveRoom(nextRoom,playerID);
                    map.setOtherRoom(currentRoom,playerID);
                    updateRoom(playerID);
                    PlayersFight playersFight = new PlayersFight(map);
                    playersFight.fightIfNeed(nextRoom,playerID);
                }

            }else {
                rejected(playerID,"Door is closed");
            }
        }else {
            rejected(playerID,"Cant forward");
        }
    }

    private void rejected(String playerID,String message){
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("result",message);
    }

    private void updateRoom(String playerID){
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("roomNumber",map.getActiveRoom(playerID).getRoomNumber());
        jsonObject.put("northSide",getSiteString(map.getActiveRoom(playerID).getSide(Direction.NORTH)));
        jsonObject.put("westSide",getSiteString(map.getActiveRoom(playerID).getSide(Direction.WEST)));
        jsonObject.put("southSide",getSiteString(map.getActiveRoom(playerID).getSide(Direction.SOUTH)));
        jsonObject.put("eastSide",getSiteString(map.getActiveRoom(playerID).getSide(Direction.EAST)));
        jsonObject.put("direction",map.getFacingDirection(playerID).ordinal());
        jsonObject.put("result","Forward success");
    }

    private String getSiteString(MapSite mapSite) {
        if (mapSite instanceof Door) {
            return "door";
        } else if (mapSite instanceof Mirror) {
            return "mirror";
        } else if (mapSite instanceof Painting) {
            return "painting";
        } else if (mapSite instanceof Seller) {
            return "seller";
        } else if (mapSite instanceof Chest) {
            return "chest";
        } else {
            return "plainwall";
        }
    }

    @Override
    public String toString() {
        return "Move Forward command";
    }
}
