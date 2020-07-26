package GameObjects;

import org.json.simple.JSONObject;

public class SwitchLight implements Command {
    private GameMap map;

    public SwitchLight(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        Room room = map.getActiveRoom(playerID);
        if (room.hasLight()) {
            room.getRoomLight().switchLight();
            jsonObject.put("result","Light switched");
        }else {
            jsonObject.put("result","No light was found in the room");
        }
    }

    @Override
    public String toString() {
        return "Switch Light command";
    }
}
