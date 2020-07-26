package GameObjects;

public class SilverKey extends Key {
    public SilverKey() {
        super("Silver key");
        MapConfiguration configuration = MapConfiguration.getInstance();
        setItemValue(configuration.getKeyGoldValue());
    }

    @Override
    public String toString() {
        return "Silver Key";
    }
}
