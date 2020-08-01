package GameObjects;

import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class PlayersFight {
    private GameMap gameMap;

    public PlayersFight(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void fightIfNeed(Room room, String playerID){
        RoomChecker roomChecker = new RoomChecker(gameMap);
        String otherPlayer = roomChecker.getBusyPlayerID(room,playerID);
        if (!otherPlayer.equals("not found")){
            int playerGold = gameMap.getPlayer(playerID).getPlayerItem(new Gold().getITEM_NAME()).getItemValue();
            int otherplayerGold = gameMap.getPlayer(otherPlayer).getPlayerItem(new Gold().getITEM_NAME()).getItemValue();

            if (playerGold>otherplayerGold){
                makePlayerLose(otherPlayer);
                takeGold(otherPlayer,otherplayerGold);
                collectItems(playerID,otherPlayer);
            }else if (otherplayerGold>playerGold){
                makePlayerLose(playerID);
                takeGold(playerID,playerGold);
                collectItems(otherPlayer,playerID);
            }else {
                gameFight(playerID,otherPlayer);
            }
        }
    }

    private void gameFight(String player1,String player2){
        GameSRP gameSRP = new GameSRP(player1,player2);
        String winner = gameSRP.getWinner();
        if (winner.equals(player1)){
            makePlayerLose(player2);
            collectItems(player1,player2);
            int goldPlayer2 = gameMap.getPlayer(player2).getPlayerItem(new Gold().getITEM_NAME()).getItemValue();
            takeGold(player2,goldPlayer2);
        }else {
            int goldPlayer1 = gameMap.getPlayer(player1).getPlayerItem(new Gold().getITEM_NAME()).getItemValue();
            makePlayerLose(player1);
            collectItems(player2,player1);
            takeGold(player1,goldPlayer1);
        }

    }

    public void makePlayerLose(String playerID1){
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID1);
        jsonObject.put("fight","lose");
    }

    public void takeGold(String loserID,int loserGold){
        int gold = loserGold/(gameMap.getPlayersNumber()-1);
        Iterator iterator = gameMap.getPlayersIterator();
        while (iterator.hasNext()){
            java.util.Map.Entry pair = (Map.Entry) iterator.next();
            Player player = (Player) pair.getValue();
            String playerID = player.getPlayerID();//(String) pair.getKey();
            if (!playerID.equals(loserID)){
                Gold gold1 = new Gold();
                Gold playerGold = (Gold) player.getPlayerItem(gold1.getITEM_NAME());
                playerGold.addGold(loserGold);
                player.addPlayerItem(playerGold);
            }
        }

    }

    public void collectItems(String playerWinner,String playerLoser){
        Iterator iterator = gameMap.getPlayer(playerLoser).getItemsIterator();

        while (iterator.hasNext()){
            java.util.Map.Entry pair = (Map.Entry) iterator.next();
            Item item = (Item) pair.getValue();
            if (item!=null) {
                gameMap.getPlayer(playerWinner).addPlayerItem(item);
            }
        }
    }

    public void removeItems(String playerLoser){
        Iterator iterator = gameMap.getPlayer(playerLoser).getItemsIterator();
        int randomRoom = (int) (Math.random() * (gameMap.getRoomsNumber() - 2 + 1) + 1);
        Chest chest = new Chest();
        while (iterator.hasNext()){
            java.util.Map.Entry pair = (Map.Entry) iterator.next();
            Item item = (Item) pair.getValue();
            if (item!=null) {
                chest.addChestItem(item);
            }
        }
        gameMap.roomNo(randomRoom).setSide(Direction.WEST,chest);
    }


}
