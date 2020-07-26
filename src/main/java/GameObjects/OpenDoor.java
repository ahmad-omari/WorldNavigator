package GameObjects;

import org.json.simple.JSONObject;

public class OpenDoor implements Command {
    private GameMap map;

    public OpenDoor(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        String result = "";
        MapSite doorSite = map.getFacingMapSite(playerID);
        if (doorSite instanceof Door){
            Key key = ((Door) doorSite).getDoorKey();
            if (key == null) {
                result = "Door opened";
                ((Door) doorSite).setDoorOpen(true);
            }else {
                if (((Door) doorSite).isOpen())
                    result = "Door opened";
                else
                    result = "The "+key.getITEM_NAME()+" required to unlock";
            }
        }
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("result",result);
    }

    @Override
    public String toString() {
        return "Open Door command";
    }
}
