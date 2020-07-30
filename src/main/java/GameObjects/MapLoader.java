package GameObjects;

public interface MapLoader {
    public GameMap createMap(MapFactory mapFactory);
    public void load();
}


