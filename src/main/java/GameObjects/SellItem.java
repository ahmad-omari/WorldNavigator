package GameObjects;

public class SellItem implements Command{
    private GameMap map;
    private Item item;

    public SellItem(GameMap map) {
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
            Item sellerGold = getSellerGold();

            Item playerItem = getPlayerItem(item.getITEM_NAME());
            Player player = map.getPlayer();

            if (playerItem.equals(new EmptyItem()))
                return;

            if (sellerGold.getItemValue() >= itemValue) {

                if (sellerGold instanceof Gold) {
                    ((Gold) sellerGold).removeGold(itemValue);
                    ((Seller) sellerSite).addSellerItem(sellerGold);
                    ((Seller) sellerSite).addSellerItem(item);

                    Item playerGold = getPlayerGold();
                    if (playerGold.equals(new EmptyItem())) {
                        playerGold = new Gold();
                        playerGold.setItemValue(itemValue);
                        player.addPlayerItem(sellerGold);
                    } else {
                        Gold addGold = (Gold) sellerGold;
                        addGold.addGold(itemValue);
                        player.addPlayerItem(addGold);
                    }
                    player.removePlayerItem(item);
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

    private Item getPlayerItem(String itemName){
        Player player = map.getPlayer();
        return player.getPlayerItem(itemName);
    }

    @Override
    public String toString() {
        return "Sell Item command";
    }
}
