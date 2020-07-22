package GameObjects;

public class TurnLeft implements Command {
    private GameMap map;

    public TurnLeft(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Player player = map.getPlayer();
        if (player.getFacingDirection().equals(Direction.NORTH))
            player.setFacingDirection(Direction.WEST);
        else if (player.getFacingDirection().equals(Direction.WEST))
            player.setFacingDirection(Direction.SOUTH);
        else if (player.getFacingDirection().equals(Direction.SOUTH))
            player.setFacingDirection(Direction.EAST);
        else if (player.getFacingDirection().equals(Direction.EAST))
            player.setFacingDirection(Direction.NORTH);
    }

    @Override
    public String toString() {
        return "Turn Left command";
    }
}
