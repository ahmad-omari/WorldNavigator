package GameObjects;

import org.json.simple.JSONObject;

public class TurnRight implements Command{
    private GameMap map;

    public TurnRight(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        Player player = map.getPlayer(playerID);
        if (player.getFacingDirection().equals(Direction.NORTH))
            player.setFacingDirection(Direction.WEST);
        else if (player.getFacingDirection().equals(Direction.WEST))
            player.setFacingDirection(Direction.SOUTH);
        else if (player.getFacingDirection().equals(Direction.SOUTH))
            player.setFacingDirection(Direction.EAST);
        else if (player.getFacingDirection().equals(Direction.EAST))
            player.setFacingDirection(Direction.NORTH);

        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("direction",player.getFacingDirection().ordinal());
        jsonObject.put("result","Turned right");
    }

    @Override
    public String toString() {
        return "Turn Right command";
    }
}
