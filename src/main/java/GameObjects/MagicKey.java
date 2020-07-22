package GameObjects;

public class MagicKey extends Key {
    public MagicKey() {
        super("Magic key");
        MapConfiguration configuration = new MapConfiguration();
        setItemValue(configuration.getKeyGoldValue());
    }

    @Override
    public String toString() {
        return "Magic Key";
    }
}
