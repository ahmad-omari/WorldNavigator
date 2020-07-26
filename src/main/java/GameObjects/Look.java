package GameObjects;

import org.json.simple.JSONObject;

public class Look implements Command{
    GameMap map;

    public Look(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        Room room = map.getActiveRoom(playerID);
        Light light = room.getRoomLight();
        String result;
        if (light != null && light.isLightON())
            result = map.getFacingMapSite(playerID).look();
        else
            result = "Dark";
        StringBuilder stringBuilder = new StringBuilder("Look: ");
        stringBuilder.append(result);
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("result",stringBuilder.toString());
    }

    @Override
    public String toString() {
        return "Look";
    }
}
