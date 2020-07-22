package GameObjects;

public class PlayerStatus implements Command {
    GameMap map;

    public PlayerStatus(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Player player = map.getPlayer();
        player.listPlayerItems();
    }

    @Override
    public String toString() {
        return "Player Status command";
    }
}
