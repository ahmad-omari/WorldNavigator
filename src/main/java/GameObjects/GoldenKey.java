package GameObjects;

public class GoldenKey extends Key {
    public GoldenKey() {
        super("Golden key");
        MapConfiguration configuration = new MapConfiguration();
        setItemValue(configuration.getKeyGoldValue());
    }

    @Override
    public String toString() {
        return "Golden Key";
    }
}
