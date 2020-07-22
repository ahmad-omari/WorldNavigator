package GameObjects;

public class Check implements Command {
    GameMap map;

    public Check(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        MapSite mapSite = map.getFacingMapSite();

        KeyChecker keyChecker;
        ItemsCollectionChecker collectionChecker;

        if (mapSite instanceof Mirror){
            keyChecker = new KeyChecker(((Mirror) mapSite).getKey());
            Key key = keyChecker.check();
            addAcquiredKey(key);
        }else if (mapSite instanceof Painting){
            keyChecker = new KeyChecker(((Painting) mapSite).getKey());
            Key key = keyChecker.check();
            addAcquiredKey(key);
        }else if (mapSite instanceof Chest){
            if (((Chest) mapSite).isChestOpen()){
                collectionChecker = new ItemsCollectionChecker(((Chest) mapSite).getChestItems());
                ItemsCollection itemsCollection = collectionChecker.check();
                addAcquiredItems(itemsCollection);
            }else {
                Key key = ((Chest) mapSite).getChestKey();
                System.out.println("Chest is closed "+ key.getITEM_NAME() +" is needed to unlock");
            }
        }else if (mapSite instanceof Door){
            if (((Door) mapSite).isOpen())
                System.out.println("Door is open");
            else {
                Key key = ((Door) mapSite).getDoorKey();
                System.out.println("Door is locked "+key.getITEM_NAME()+" is needed to unlock");
            }
        }

    }

    private void addAcquiredKey(Key key){
        if (key instanceof EmptyKey) {
            System.out.println("Nothing found");
        }else {
            Player player = map.getPlayer();
            player.addPlayerItem(key);
        }
    }

    private void addAcquiredItems(ItemsCollection itemsCollection){
        if (!itemsCollection.isEmpty()){
            Player player = map.getPlayer();
            player.addPlayerItems(itemsCollection);
        }else {
            System.out.println("Nothing found");
        }
    }

    @Override
    public String toString() {
        return "Check command";
    }
}
