package GameObjects;

public class UseFlashLight implements Command {
    private GameMap map;

    public UseFlashLight(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        FlashLight flashLight=new FlashLight();
        Player player = map.getPlayer();
        Room room = map.getActiveRoom();
        Item flashLightItem = player.getPlayerItem(flashLight.getITEM_NAME());
        if (flashLightItem instanceof FlashLight) {
            flashLight.switchLight();
            Light light = new Light();
            light.setLightON(flashLight.isLightON());
            room.setRoomLight(light);
        }
    }

    @Override
    public String toString() {
        return "Use FlashLight command";
    }
}
