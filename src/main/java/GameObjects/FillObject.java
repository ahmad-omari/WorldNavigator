package GameObjects;

import org.json.simple.JSONObject;

public class FillObject {
    private GameMap gameMap;
    private String playerID;

    public FillObject(GameMap gameMap, String playerID) {
        this.gameMap = gameMap;
        this.playerID = playerID;
    }

    public void fetchDataFromMap(){
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("gameID",gameMap.getMapID());
        jsonObject.put("numberOfRooms",gameMap.getRoomsNumber());
        jsonObject.put("gold",gameMap.getPlayer(playerID).getPlayerItem(new Gold().getITEM_NAME()).getItemValue());
        jsonObject.put("roomNumber",gameMap.getActiveRoom(playerID).getRoomNumber());
        jsonObject.put("northSide",getSiteString(gameMap.getActiveRoom(playerID).getSide(Direction.NORTH)));
        jsonObject.put("westSide",getSiteString(gameMap.getActiveRoom(playerID).getSide(Direction.WEST)));
        jsonObject.put("southSide",getSiteString(gameMap.getActiveRoom(playerID).getSide(Direction.SOUTH)));
        jsonObject.put("eastSide",getSiteString(gameMap.getActiveRoom(playerID).getSide(Direction.EAST)));
        jsonObject.put("direction",gameMap.getFacingDirection(playerID).ordinal());
        jsonObject.put("result","World navigator game");
        PlayerInfo.addJSONObject(playerID,jsonObject);
    }
    public void fetchResult(String result){
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("result",result);
        PlayerInfo.addJSONObject(playerID,jsonObject);
    }

    private String getSiteString(MapSite mapSite){
        if (mapSite instanceof Door){
            return "door";
        }else if (mapSite instanceof Mirror){
            return "mirror";
        }else if (mapSite instanceof Painting){
            return "painting";
        }else if (mapSite instanceof Seller){
            return "seller";
        }else if (mapSite instanceof Chest){
            return "chest";
        }else {
            return "plainwall";
        }
    }
}
