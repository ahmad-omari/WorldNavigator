package GameObjects;

import org.json.simple.JSONObject;

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
    public void execute(String playerID) {
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        MapSite sellerSite = map.getFacingMapSite(playerID);
        if (sellerSite instanceof Seller && !item.equals(new EmptyItem())) {
            StringBuilder stringBuilder = new StringBuilder();
            int itemValue = getItemValue();
            Item sellerGold = getSellerGold(playerID);

            Item playerItem = getPlayerItem(item.getITEM_NAME(),playerID);
            Player player = map.getPlayer(playerID);

            if (playerItem.equals(new EmptyItem()))
                return;

            if (sellerGold.getItemValue() >= itemValue) {

                if (sellerGold instanceof Gold) {
                    ((Gold) sellerGold).removeGold(itemValue);
                    ((Seller) sellerSite).addSellerItem(sellerGold);
                    ((Seller) sellerSite).addSellerItem(item);

                    Item playerGold = getPlayerGold(playerID);
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
                stringBuilder.append("Successful sold");
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

    private Item getPlayerItem(String itemName,String playerID){
        Player player = map.getPlayer(playerID);
        return player.getPlayerItem(itemName);
    }

    @Override
    public String toString() {
        return "Sell Item command";
    }
}
