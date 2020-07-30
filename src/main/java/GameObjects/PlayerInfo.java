package GameObjects;
import org.json.simple.JSONObject;
import java.util.HashMap;

public class PlayerInfo {
    private static HashMap<String, JSONObject> playersInfo = new HashMap<>();

    public PlayerInfo(){

    }

    public void createJSONObject(String playerID){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gameID",0);
        jsonObject.put("numberOfRooms",0);
        jsonObject.put("playersNumber",0);
        jsonObject.put("gold",0);
        jsonObject.put("roomNumber",0);
        jsonObject.put("northSide","");
        jsonObject.put("westSide","");
        jsonObject.put("southSide","");
        jsonObject.put("eastSide","");
        jsonObject.put("direction","");
        jsonObject.put("result","");
        playersInfo.put(playerID,jsonObject);
    }

    public static void addJSONObject(String playerID,JSONObject jsonObject){
        playersInfo.put(playerID,jsonObject);
    }

    public static JSONObject getJSONObject(String playerID){
        return playersInfo.get(playerID);
    }

    public static void removeJSONObject(String playerID){
        playersInfo.remove(playerID);
    }

    public static int getNumberOfJSON(){
        return playersInfo.size();
    }
}
