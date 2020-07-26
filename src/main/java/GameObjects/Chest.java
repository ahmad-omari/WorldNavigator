package GameObjects;

public class Chest implements MapSite {
    private ItemsCollection chestItems;
    private Key chestKey;
    private boolean chestOpen;

    public Chest() {
        chestItems = new ItemsCollection();
        chestOpen = true;
    }

    public void addChestItem(Item item){
        chestItems.addItem(item);
    }

    public void removeChestItem(Item item){
        chestItems.removeItem(item);
    }

    public Item getChestItem(String itemName){
        return chestItems.getItem(itemName);
    }

    public ItemsCollection getChestItems() {
        return chestItems;
    }

    public void listChestItems(){
        chestItems.listItems();
    }

    public boolean isChestItemsEmpty(){
        return chestItems.isEmpty();
    }

    public void setChestKey(Key chestKey) {
        if (chestKey != null) {
            this.chestKey = chestKey;
            setChestOpen(false);
        }
    }

    public void setChestOpen(boolean chestOpen) {
        this.chestOpen = chestOpen;
    }

    public Key getChestKey() {
        return chestKey;
    }

    public boolean isChestOpen() {
        return chestOpen;
    }

    @Override
    public String look() {
        return "You are facing a chest";
    }

    @Override
    public String toString() {
        return "Chest";
    }
}
