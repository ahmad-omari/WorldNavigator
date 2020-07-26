package GameObjects;

import org.json.simple.JSONObject;

public class MapController {
    private GameMap map;
    private MapCommands gameCommands;
    private MapCommands tradeCommands;
    private boolean gameMode;

    public MapController(GameMap map) {
        this.map = map;
        gameMode = true;
        gameCommands = new GameCommand(map);
        tradeCommands = new TradeCommand(map);
        makeCommands();
    }

    public void makeCommands(){
        gameCommands.makeCommands();
        tradeCommands.makeCommands();
    }

    private void listCommands(){
        System.out.println("Game Mode Commands :");
        gameCommands.listCommandSet();
        System.out.println("Trade Mode Commands :");
        tradeCommands.listCommandSet();
        System.out.println();
    }

    public void makeAction(String actionRequest,String playerID){
        checkMode(actionRequest,playerID);
        if (gameMode)
            gameCommands.invoke(actionRequest,playerID);
        else
            tradeCommands.invoke(actionRequest,playerID);
    }

    private void checkMode(String actionRequest,String playerID) {
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        if (actionRequest.toLowerCase().equals("trade")){
            checkStartTrade(playerID);
            jsonObject.put("result","Trade mode active");
        }else if (actionRequest.toLowerCase().equals("finish")){
            checkEndTrade();
            jsonObject.put("result","Trade mode finished");
        }
        String [] commandOfTrade = actionRequest.split("\\s");
        if (commandOfTrade[0].equals("buy") || commandOfTrade[0].equals("sell")){
            checkStartTrade(playerID);
        }
    }

    private void checkStartTrade(String playerID){
        MapSite sellerSite = map.getFacingMapSite(playerID);
        if (sellerSite instanceof Seller) {
            gameMode = false;
            System.out.println("You are in trade mode, enter <<finish>> to return game mode");
        }
    }

    private void checkEndTrade() {
        if (!gameMode)
            gameMode = true;
        System.out.println("You are in game mode");
    }

    @Override
    public String toString() {
        return "Map Controller";
    }
}
