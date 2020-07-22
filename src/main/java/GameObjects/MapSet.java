package GameObjects;

import java.util.ArrayList;
import java.util.List;

public class MapSet {
    private MapLoader mapLoader;

    public MapSet(){

    }

    public void makeMaps(){
        mapLoader = new Map();
    }

    public MapLoader getMapLoader(){
        return mapLoader;
    }


    @Override
    public String toString() {
        return "Map Set";
    }
}
