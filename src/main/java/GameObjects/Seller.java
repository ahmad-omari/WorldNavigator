package GameObjects;

public class Seller implements MapSite {
    private ItemsCollection playerItems;

    public Seller(){
        playerItems = new ItemsCollection();
    }

    public void addSellerItem(Item item){
        playerItems.addItem(item);
    }

    public void removeSellerItem(Item item){
        playerItems.removeItem(item);
    }

    public Item getSellerItem(String itemName){
        return playerItems.getItem(itemName);
    }

    public String listSellerItems(){
        return playerItems.listItems();
    }

    @Override
    public String look() {
        return "You are facing a seller";
    }

    @Override
    public String toString() {
        return "Seller";
    }
}
