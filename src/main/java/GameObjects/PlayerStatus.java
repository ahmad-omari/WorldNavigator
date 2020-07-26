package GameObjects;

import org.json.simple.JSONObject;

public class PlayerStatus implements Command {
    GameMap map;

    public PlayerStatus(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        Player player = map.getPlayer(playerID);
        String result = player.listPlayerItems();
        StringBuilder stringBuilder = new StringBuilder("Player Status: ");
        stringBuilder.append(result);
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("result",stringBuilder.toString());
    }

    @Override
    public String toString() {
        return "Player Status command";
    }
}
