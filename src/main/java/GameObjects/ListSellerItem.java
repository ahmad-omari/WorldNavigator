package GameObjects;

import org.json.simple.JSONObject;

public class ListSellerItem implements Command {
    private GameMap map;

    public ListSellerItem(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        MapSite sellerSite = map.getFacingMapSite(playerID);
        if (sellerSite instanceof Seller){
            String result = ((Seller) sellerSite).listSellerItems();
            JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
            jsonObject.put("result",result);
        }
    }

    @Override
    public String toString() {
        return "List Seller Items command";
    }
}
