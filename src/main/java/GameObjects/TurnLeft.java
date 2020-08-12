package GameObjects;

import org.json.simple.JSONObject;

public class TurnLeft implements Command {
    private GameMap map;

    public TurnLeft(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        Player player = map.getPlayer(playerID);
        if (player.getFacingDirection().equals(Direction.NORTH))
            player.setFacingDirection(Direction.EAST);
        else if (player.getFacingDirection().equals(Direction.WEST))
            player.setFacingDirection(Direction.NORTH);
        else if (player.getFacingDirection().equals(Direction.SOUTH))
            player.setFacingDirection(Direction.WEST);
        else if (player.getFacingDirection().equals(Direction.EAST))
            player.setFacingDirection(Direction.SOUTH);
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("direction",player.getFacingDirection().ordinal());
        jsonObject.put("result","Turned left");
    }

    @Override
    public String toString() {
        return "Turn Left command";
    }
}
