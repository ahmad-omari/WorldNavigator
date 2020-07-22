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

    public void listSellerItems(){
        playerItems.listItems();
    }

    @Override
    public void look() {
        System.out.println("You are facing a seller");
    }

    @Override
    public String toString() {
        return "Seller";
    }
}
