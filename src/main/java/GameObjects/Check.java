package GameObjects;

import org.json.simple.JSONObject;

public class Check implements Command {
    GameMap map;

    public Check(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute(String playerID) {
        MapSite mapSite = map.getFacingMapSite(playerID);
        KeyChecker keyChecker;
        ItemsCollectionChecker collectionChecker;
        StringBuilder stringBuilder = new StringBuilder();
        if (mapSite instanceof Mirror){
            keyChecker = new KeyChecker(((Mirror) mapSite).getKey());
            Key key = keyChecker.check();
            String result = addAcquiredKey(key,playerID);
            stringBuilder.append(result);
        }else if (mapSite instanceof Painting){
            keyChecker = new KeyChecker(((Painting) mapSite).getKey());
            Key key = keyChecker.check();
            String result = addAcquiredKey(key,playerID);
            stringBuilder.append(result);
        }else if (mapSite instanceof Chest){
            if (((Chest) mapSite).isChestOpen()){
                collectionChecker = new ItemsCollectionChecker(((Chest) mapSite).getChestItems());
                ItemsCollection itemsCollection = collectionChecker.check();
                String result = addAcquiredItems(itemsCollection,playerID);
                stringBuilder.append(result);
            }else {
                Key key = ((Chest) mapSite).getChestKey();
                stringBuilder.append("Chest is closed "+ key.getITEM_NAME() +" is needed to unlock");
            }
        }else if (mapSite instanceof Door){
            if (((Door) mapSite).isOpen())
                stringBuilder.append("Door is open");
            else {
                Key key = ((Door) mapSite).getDoorKey();
                stringBuilder.append("Door is locked "+key.getITEM_NAME()+" is needed to unlock");
            }
        }

        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        jsonObject.put("result",stringBuilder.toString());
    }

    private String addAcquiredKey(Key key,String playerID){
        if (key instanceof EmptyKey) {
            return "Nothing found";
        }else {
            Player player = map.getPlayer(playerID);
            player.addPlayerItem(key);
            return "Key "+key.getITEM_NAME()+" Acquired";
        }
    }

    private String addAcquiredItems(ItemsCollection itemsCollection,String playerID){
        if (!itemsCollection.isEmpty()){
            Player player = map.getPlayer(playerID);
            player.addPlayerItems(itemsCollection);
            return itemsCollection.listItems();
        }else {
            return "Nothing found";
        }
    }

    @Override
    public String toString() {
        return "Check command";
    }
}
