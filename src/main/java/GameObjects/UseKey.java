package GameObjects;

import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class UseKey implements Command {
    GameMap map;

    public UseKey(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        MapSite site = map.getFacingMapSite(playerID);
        Key key;
        if (site instanceof Door){
            key = ((Door) site).getDoorKey();
            boolean keyFounded = isKeyFounded(key,playerID);
            if (keyFounded){
                ((Door) site).setDoorOpen(true);
                jsonObject.put("result","Door opened");
                return;
            }
        }else if (site instanceof Chest){
            key = ((Chest) site).getChestKey();
            boolean keyFounded = isKeyFounded(key,playerID);
            if (keyFounded){
                ((Chest) site).setChestOpen(true);
                jsonObject.put("result","Chest opened");
                return;
            }
        }
        jsonObject.put("result","You cant use key");
    }

    private boolean isKeyFounded(Key key,String playerID){
        boolean found = false;
        if (key != null){
            Player player = map.getPlayer(playerID);
            Iterator iterator = player.getItemsIterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                if (pair.getKey().equals(key.getITEM_NAME())) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return "Use Key command";
    }
}
