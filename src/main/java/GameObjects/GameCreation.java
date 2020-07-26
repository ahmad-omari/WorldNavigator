package GameObjects;

import org.json.simple.JSONObject;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class GameCreation {
    private GameListener gameListener;
    private HttpSession httpSession;
    private PlayerInfo playerInfo;
    private static HashMap<String,Boolean> usersRegistered = new HashMap<>();

    public GameCreation(HttpSession session){
        gameListener = new GameListener();
        httpSession = session;
        playerInfo = new PlayerInfo();
    }

    public void createGame() {
        if (usersRegistered.get(httpSession.getId()) != null) {
            return;
        }
        System.out.println("map created by "+httpSession.getId());
        gameListener.setNumberOfPlayers((Integer) httpSession.getAttribute("numberofplayers"));
        GameMap gameMap = gameListener.createMap();
        gameMap.addPlayer(httpSession.getId());
        httpSession.setAttribute("mapID",gameMap.getMapID());
        preparePlayerData(gameMap);
        usersRegistered.put(httpSession.getId(),true);
    }
    private void preparePlayerData(GameMap gameMap){
        playerInfo.createJSONObject(httpSession.getId());
        FillObject fillObject = new FillObject(gameMap,httpSession.getId());
        fillObject.fetchDataFromMap();
    }

}
