package GameObjects;

import java.util.HashMap;

public class GameListener {
    private static HashMap<Integer,GameMap> gameMaps = new HashMap<>();
    private static int mapID=0;
    private static int numberOfPlayers;

    public GameListener(){
       // gameMaps = new HashMap<>();
      //  mapID = 0;
      //  numberOfPlayers = 0;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        if (this.numberOfPlayers==0) {
            System.out.println("modi number of players");
            this.numberOfPlayers = numberOfPlayers;
        }
    }

    public GameMap createMap(){
        System.out.println("number of players "+numberOfPlayers+" maps:"+gameMaps.size());
        System.out.println("passed the test players "+numberOfPlayers+" mapid:"+mapID+" iscreated:"+gameMaps.get(mapID)!=null+" isavailable:"+(gameMaps.get(mapID)!=null && gameMaps.get(mapID).isAvailable()));
        if (numberOfPlayers>0 && gameMaps.get(mapID)!=null && gameMaps.get(mapID).isAvailable()){
            numberOfPlayers--;
            if (numberOfPlayers==0)
                gameMaps.get(mapID).setAvailable(false);
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
