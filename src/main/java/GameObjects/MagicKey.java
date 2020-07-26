package GameObjects;

public class MagicKey extends Key {
    public MagicKey() {
        super("Magic key");
        MapConfiguration configuration = MapConfiguration.getInstance();
        setItemValue(configuration.getKeyGoldValue());
    }

    @Override
    public String toString() {
        return "Magic Key";
    }
}
