package GameObjects;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapConfiguration {
    private JSONObject jsonObject;

    public MapConfiguration(){
        this.jsonObject=null;
        readJSON();
    }

    private void readJSON(){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("MapContent.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            this.jsonObject = (JSONObject) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getMinNumberOfRooms(){
        if (jsonObject==null)
            throw new RuntimeException();
        int value=0;
        try {
            value = Integer.parseInt(jsonObject.get("minNumberOfRooms").toString());
        }catch (Exception e){e.printStackTrace();}
        return value;
    }

    public int getMaxNumberOfRooms(){
        if (jsonObject==null)
            throw new RuntimeException();
        int value=0;
        try {
            value = Integer.parseInt(jsonObject.get("maxNumberOfRooms").toString());
        }catch (Exception e){e.printStackTrace();}
        return value;
    }

    public int getMinNumberOfSpecialDoors(){
        if (jsonObject==null)
            throw new RuntimeException();
        int value=0;
        try {
            value = Integer.parseInt(jsonObject.get("minNumberOfSpecialDoors").toString());
        }catch (Exception e){e.printStackTrace();}
        return value;
    }

    public int getMaxNumberOfSpecialDoors(){
        if (jsonObject==null)
            throw new RuntimeException();
        int value=0;
        try {
            value = Integer.parseInt(jsonObject.get("maxNumberOfSpecialDoors").toString());
        }catch (Exception e){e.printStackTrace();}
        return value;
    }

    public int getPlayerInitialGold(){
        if (jsonObject==null)
            throw new RuntimeException();
        int value=0;
        try {
            value = Integer.parseInt(jsonObject.get("playerInitialGold").toString());
        }catch (Exception e){e.printStackTrace();}
        return value;
    }

    public int getKeyGoldValue(){
        if (jsonObject==null)
            throw new RuntimeException();
        int value=0;
        try {
            value = Integer.parseInt(jsonObject.get("keyGoldValue").toString());
        }catch (Exception e){e.printStackTrace();}
        return value;
    }

    public int getFlashlightGoldValue(){
        if (jsonObject==null)
            throw new RuntimeException();
        int value=0;
        try {
            value = Integer.parseInt(jsonObject.get("flashlightGoldValue").toString());
        }catch (Exception e){e.printStackTrace();}
        return value;
    }

}
