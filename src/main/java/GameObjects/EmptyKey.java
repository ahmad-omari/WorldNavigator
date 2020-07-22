package GameObjects;

public class EmptyKey extends Key {
    public EmptyKey() {
        super("empty");
        setItemValue(0);
    }

    @Override
    public String toString() {
        return "Empty Key";
    }
}
