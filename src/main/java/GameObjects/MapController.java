package GameObjects;

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
    }

    public void makeCommands(){
        gameCommands.makeCommands();
        tradeCommands.makeCommands();
        listCommands();
    }

    private void listCommands(){
        System.out.println("Game Mode Commands :");
        gameCommands.listCommandSet();
        System.out.println("Trade Mode Commands :");
        tradeCommands.listCommandSet();
        System.out.println();
    }

    public void makeAction(String actionRequest){
        checkMode(actionRequest);
        if (gameMode)
            gameCommands.invoke(actionRequest);
        else
            tradeCommands.invoke(actionRequest);
    }

    private void checkMode(String actionRequest) {
        if (actionRequest.toLowerCase().equals("trade")){
            checkStartTrade();
        }else if (actionRequest.toLowerCase().equals("finish")){
            checkEndTrade();
        }
    }

    private void checkStartTrade(){
        MapSite sellerSite = map.getFacingMapSite();
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
