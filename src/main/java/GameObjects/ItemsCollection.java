package GameObjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ItemsCollection {
    private Map<String,Item> itemsCollection;

    public ItemsCollection(){
        itemsCollection = new HashMap<>();
    }

    public void addItem(Item item){
        if (item == null)
            throw new IllegalArgumentException();

        itemsCollection.put(item.getITEM_NAME(),item);
    }

    public void removeItem(Item item){
        if (!itemsCollection.containsKey(item.getITEM_NAME()))
            throw new IllegalArgumentException("Item does not exist");
        if (item == null)
            throw new IllegalArgumentException();
        itemsCollection.remove(item.getITEM_NAME());
    }

    public Item getItem(String itemName){
        if (itemsCollection.containsKey(itemName)){
            return itemsCollection.get(itemName);
        }
        return new EmptyItem();
    }

    public void addCollectionItems(ItemsCollection collection){
        Iterator iterator = collection.itemsIterator();

        while (iterator.hasNext()){
            Map.Entry pair = (Map.Entry) iterator.next();
            Item item = collection.getItem((String) pair.getKey());
            itemsCollection.put(item.getITEM_NAME(),item);
        }
    }

    public String listItems(){
        StringBuilder stringBuilder = new StringBuilder();
        if (isEmpty()) {
            System.out.println("Items list is empty");
            stringBuilder.append("Items list is empty\n");
        }else {
            System.out.println("Items list :");
            stringBuilder.append("Items list :\n");
            Iterator iterator = itemsIterator();
            while (iterator.hasNext()){
                Map.Entry pair = (Map.Entry) iterator.next();
                int itemValue = itemsCollection.get(pair.getKey()).getItemValue();
                System.out.println("Item name : "+pair.getKey() +"\nItem value : "+ itemValue+"\n");
                stringBuilder.append("Item name : "+pair.getKey() +"\nItem value : "+ itemValue+"\n");
            }
            System.out.print("\n");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Iterator itemsIterator(){
        return itemsCollection.entrySet().iterator();
    }

    public boolean isEmpty(){
        return itemsCollection.isEmpty();
    }

    @Override
    public String toString() {
        return "Items";
    }
}
