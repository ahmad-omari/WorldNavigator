package GameObjects;

import org.json.simple.JSONObject;

public class UseFlashLight implements Command {
    private GameMap map;

    public UseFlashLight(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        FlashLight flashLight=new FlashLight();
        Player player = map.getPlayer(playerID);
        Room room = map.getActiveRoom(playerID);
        Item flashLightItem = player.getPlayerItem(flashLight.getITEM_NAME());
        if (flashLightItem instanceof FlashLight) {
            flashLight.switchLight();
            Light light = new Light();
            light.setLightON(flashLight.isLightON());
            room.setRoomLight(light);
            jsonObject.put("result","Flashlight used.");
        }else {
            jsonObject.put("result","You dont have Flashlight.");
        }
    }

    @Override
    public String toString() {
        return "Use FlashLight command";
    }
}
