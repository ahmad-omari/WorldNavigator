package GameObjects;

import java.util.HashMap;

public class GameListener {
    private static HashMap<Integer,GameMap> gameMaps = new HashMap<>();
    private static int mapID=0;
    private static int numberOfPlayers;

    public GameListener(){

    }

    public static int numberOfMaps(){
        return gameMaps.size();
    }

    public void setNumberOfPlayers(int numberplayers) {
        if (numberOfPlayers==0) {
            System.out.println("modi number of players");
            numberOfPlayers = numberplayers;
        }
    }


    public synchronized GameMap createMap(){
        System.out.println("number of players "+numberOfPlayers+" maps:"+gameMaps.size());
         if (numberOfPlayers>0 && gameMaps.get(mapID)!=null && (!gameMaps.get(mapID).isClosed())){
            numberOfPlayers--;
            if (numberOfPlayers==0)
                gameMaps.get(mapID).setClosed(true);
             // numberOfPlayers-=(1+gameMaps.get(mapID).getPlayersNumber());
           // if (numberOfPlayers==0)
             //   gameMaps.get(mapID).setAvailable(false);
            return gameMaps.get(mapID);
        }

        MapFactory mapFactory = new MapFactory();
        MapSet mapSet = new MapSet();
        mapSet.makeMaps();
        MapLoader mapLoader = mapSet.getMapLoader();
        mapLoader.load();
        GameMap map = mapLoader.createMap(mapFactory);
        numberOfPlayers--;
        return registerMap(map);
    }

    private GameMap registerMap(GameMap map){
        mapID++;
        map.setMapID(mapID);
        gameMaps.put(mapID,map);
        return map;
    }

    public static GameMap getGameMap(int mapID){
        return gameMaps.get(mapID);
    }

    public static void removeMap(int mapID){gameMaps.remove(mapID);}
}
