package GameObjects;

public class ListSellerItem implements Command {
    private GameMap map;

    public ListSellerItem(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        MapSite sellerSite = map.getFacingMapSite();
        if (sellerSite instanceof Seller){
            ((Seller) sellerSite).listSellerItems();
        }
    }

    @Override
    public String toString() {
        return "List Seller Items command";
    }
}
