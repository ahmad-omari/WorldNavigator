package GameObjects;

import java.util.Iterator;
import java.util.Map;

public class UseKey implements Command {
    GameMap map;

    public UseKey(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {
        MapSite site = map.getFacingMapSite();
        Key key;
        if (site instanceof Door){
            key = ((Door) site).getDoorKey();
            boolean keyFounded = isKeyFounded(key);
            if (keyFounded){
                ((Door) site).setDoorOpen(true);
            }
        }else if (site instanceof Chest){
            key = ((Chest) site).getChestKey();
            boolean keyFounded = isKeyFounded(key);
            if (keyFounded){
                ((Chest) site).setChestOpen(true);
            }
        }else {
            System.out.println("You cant use key");
            return;
        }

    }

    private boolean isKeyFounded(Key key){
        boolean found = false;
        if (key != null){
            Player player = map.getPlayer();
            Iterator iterator = player.getItemsIterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                if (pair.getKey().equals(key.getITEM_NAME())) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return "Use Key command";
    }
}
