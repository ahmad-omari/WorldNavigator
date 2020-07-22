package GameObjects;

public class ItemsCollectionChecker {
    private ItemsCollection itemsCollection;

    public ItemsCollectionChecker(ItemsCollection itemsCollection) {
        this.itemsCollection = itemsCollection;
    }

    public ItemsCollection check(){
        if (itemsCollection != null && !itemsCollection.isEmpty()){
            itemsCollection.listItems();
            System.out.println("All items has been acquired");
            return itemsCollection;
        }
        return itemsCollection;
    }

    @Override
    public String toString() {
        return "Items checker";
    }
}
