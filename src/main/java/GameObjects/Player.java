package GameObjects;

import java.util.Iterator;

public class Player {
   // private final String playerName;
    private ItemsCollection playerItems;
    private Direction facingDirection;

    public Player(){//String playerName){
       // this.playerName = playerName;
        playerItems = new ItemsCollection();
        facingDirection = Direction.NORTH;
    }
/*
    public String getPlayerName() {
        return playerName;
    }

 */

    public void addPlayerItem(Item item){
        playerItems.addItem(item);
    }

    public void addPlayerItems(ItemsCollection itemsCollection){playerItems.addCollectionItems(itemsCollection);}

    public Iterator getItemsIterator(){return playerItems.itemsIterator();}

    public void removePlayerItem(Item item){
        playerItems.removeItem(item);
    }

    public Item getPlayerItem(String itemName){
        return playerItems.getItem(itemName);
    }

    public void listPlayerItems(){
        playerItems.listItems();
    }

    public boolean isPlayerItemsEmpty(){
        return playerItems.isEmpty();
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public String toString() {
        return "Player";
    }
}
