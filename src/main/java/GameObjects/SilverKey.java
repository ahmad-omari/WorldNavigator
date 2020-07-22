package GameObjects;

public class SilverKey extends Key {
    public SilverKey() {
        super("Silver key");
        MapConfiguration configuration = new MapConfiguration();
        setItemValue(configuration.getKeyGoldValue());
    }

    @Override
    public String toString() {
        return "Silver Key";
    }
}
