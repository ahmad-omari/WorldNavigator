package GameObjects;

public class GoldenKey extends Key {
    public GoldenKey() {
        super("Golden key");
        MapConfiguration configuration = MapConfiguration.getInstance();
        setItemValue(configuration.getKeyGoldValue());
    }

    @Override
    public String toString() {
        return "Golden Key";
    }
}
