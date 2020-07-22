package GameObjects;

import java.util.Objects;

public abstract class Item {
    private final String ITEM_NAME;
    private int itemValue;

    public Item(String itemName){
        this.ITEM_NAME = itemName;
    }

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return ITEM_NAME.equals(item.ITEM_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ITEM_NAME);
    }

    @Override
    public String toString() {
        return "Item";
    }
}
