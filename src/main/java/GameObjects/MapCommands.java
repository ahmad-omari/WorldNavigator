package GameObjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class MapCommands {
    protected Map<String,Invoker> commandsMap;
    protected GameMap map;

    public MapCommands(GameMap map) {
        this.map = map;
        commandsMap = new HashMap<>();
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public void listCommandSet() {
        if (!commandsMap.isEmpty()) {
            Iterator iterator = commandsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                String commandName = pair.getKey().toString();
                if (commandName.equals("buy") || commandName.equals("sell")){
                    System.out.print(commandName+" <<item name>>, ");
                    continue;
                }
                System.out.print(pair.getKey() + ", ");
            }
            System.out.println("\n");
        }
    }

    public abstract void makeCommands();

    public abstract void invoke(String commandRequest);

    @Override
    public String toString() {
        return "Map Commands";
    }
}
