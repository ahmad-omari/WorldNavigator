package GameObjects;

public class BuyItem implements Command {
    private GameMap map;
    private Item item;

    public BuyItem(GameMap map) {
        this.map = map;
        item = new EmptyItem();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        MapSite sellerSite = map.getFacingMapSite();
        if (sellerSite instanceof Seller && !item.equals(new EmptyItem())) {
            int itemValue = getItemValue();
            Item playerGold = getPlayerGold();
            Item sellerItem = getSellerItem(item.getITEM_NAME());
            Player player = map.getPlayer();

            if (sellerItem.equals(new EmptyItem()))
                return;

            if (playerGold.getItemValue() >= itemValue) {

                if (playerGold instanceof Gold) {
                    ((Gold) playerGold).removeGold(itemValue);
                    player.addPlayerItem(playerGold);
                    player.addPlayerItem(item);

                    Item sellerGold = getSellerGold();
                    if (sellerGold.equals(new EmptyItem())) {
                        sellerGold = new Gold();
                        sellerGold.setItemValue(itemValue);
                        ((Seller) sellerSite).addSellerItem(sellerGold);
                    } else {
                        Gold addGold = (Gold) sellerGold;
                        addGold.addGold(itemValue);
                        ((Seller) sellerSite).addSellerItem(addGold);
                    }
                    ((Seller) sellerSite).removeSellerItem(item);
                }

            } else {
                System.out.println("Return when you have enough gold");
            }
        }

    }

    private int getItemValue(){
        return item.getItemValue();
    }

    private Item getSellerGold(){
        MapSite sellerSite = map.getFacingMapSite();
        if (sellerSite instanceof Seller){
            Gold gold = new Gold();
            Item sellerGoldItem = ((Seller) sellerSite).getSellerItem(gold.getITEM_NAME());
            if (sellerGoldItem.equals(gold)){
                return sellerGoldItem;
            }
        }
        return new EmptyItem();
    }

    private Item getPlayerGold(){
        Player player = map.getPlayer();
        Gold gold = new Gold();
        Item playerGoldItem = player.getPlayerItem(gold.getITEM_NAME());
        if (playerGoldItem.equals(gold))
            return playerGoldItem;
        return new EmptyItem();
    }

    private Item getSellerItem(String itemName){
        MapSite sellerSite = map.getFacingMapSite();
        if (sellerSite instanceof Seller)
            return ((Seller) sellerSite).getSellerItem(itemName);
        return new EmptyItem();
    }

    @Override
    public String toString() {
        return "Buy Item";
    }
}
