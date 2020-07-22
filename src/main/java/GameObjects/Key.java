package GameObjects;

public abstract class Key extends Item {

    public Key(String itemName) {
        super(itemName);
    }

    @Override
    public String toString() {
        return "Key";
    }
}
