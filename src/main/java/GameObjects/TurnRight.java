package GameObjects;

public class TurnRight implements Command{
    private GameMap map;

    public TurnRight(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Player player = map.getPlayer();
        if (player.getFacingDirection().equals(Direction.NORTH))
            player.setFacingDirection(Direction.EAST);
        else if (player.getFacingDirection().equals(Direction.WEST))
            player.setFacingDirection(Direction.NORTH);
        else if (player.getFacingDirection().equals(Direction.SOUTH))
            player.setFacingDirection(Direction.WEST);
        else if (player.getFacingDirection().equals(Direction.EAST))
            player.setFacingDirection(Direction.SOUTH);
    }

    @Override
    public String toString() {
        return "Turn Right command";
    }
}
