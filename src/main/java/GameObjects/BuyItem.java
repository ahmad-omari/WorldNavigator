package GameObjects;

import org.json.simple.JSONObject;

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
    public void execute(String playerID) {
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        MapSite sellerSite = map.getFacingMapSite(playerID);
        if (sellerSite instanceof Seller && !item.equals(new EmptyItem())) {
            StringBuilder stringBuilder = new StringBuilder();
            int itemValue = getItemValue();
            Item playerGold = getPlayerGold(playerID);
            Item sellerItem = getSellerItem(item.getITEM_NAME(),playerID);
            Player player = map.getPlayer(playerID);

            if (sellerItem.equals(new EmptyItem()))
                return;

            if (playerGold.getItemValue() >= itemValue) {

                if (playerGold instanceof Gold) {
                    ((Gold) playerGold).removeGold(itemValue);
                    player.addPlayerItem(playerGold);
                    player.addPlayerItem(item);

                    Item sellerGold = getSellerGold(playerID);
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
                stringBuilder.append("Successful purchase");
            } else {
                stringBuilder.append("Return when you have enough gold");
            }

            jsonObject.put("result",stringBuilder.toString());
            return;
        }
        jsonObject.put("result","Cant trade");
    }

    private int getItemValue(){
        return item.getItemValue();
    }

    private Item getSellerGold(String playerID){
        MapSite sellerSite = map.getFacingMapSite(playerID);
        if (sellerSite instanceof Seller){
            Gold gold = new Gold();
            Item sellerGoldItem = ((Seller) sellerSite).getSellerItem(gold.getITEM_NAME());
            if (sellerGoldItem.equals(gold)){
                return sellerGoldItem;
            }
        }
        return new EmptyItem();
    }

    private Item getPlayerGold(String playerID){
        Player player = map.getPlayer(playerID);
        Gold gold = new Gold();
        Item playerGoldItem = player.getPlayerItem(gold.getITEM_NAME());
        if (playerGoldItem.equals(gold))
            return playerGoldItem;
        return new EmptyItem();
    }

    private Item getSellerItem(String itemName,String playerID){
        MapSite sellerSite = map.getFacingMapSite(playerID);
        if (sellerSite instanceof Seller)
            return ((Seller) sellerSite).getSellerItem(itemName);
        return new EmptyItem();
    }

    @Override
    public String toString() {
        return "Buy Item";
    }
}
