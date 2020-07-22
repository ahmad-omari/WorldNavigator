package GameObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameDriver {
    private MapController controller;
    private MapSet mapSet;
    private GameTimer timer;
    private long timeInMinutes;

    public GameDriver(){
        mapSet = new MapSet();
        mapSet.makeMaps();
    }

    public void play(){
        prepareMap();
    }

    private void prepareMap() {
        MapFactory mapFactory = new MapFactory();
        MapLoader mapLoader = mapSet.getMapLoader();
        mapLoader.load();
        GameMap map = mapLoader.createMap(mapFactory);
        calculateMapTimeInMinutes(map.getRoomsNumber());
        controller = new MapController(map);
        startGame();
    }

    private void startGame() {
        setGameStatus(true);
        terminatePrompt();
        controller.makeCommands();
        timer = new GameTimer();
        timer.setTimeInMinutes(timeInMinutes);
        timer.start();
        readCommands();
        timer.stop();
    }

    private void calculateMapTimeInMinutes(int numberOfRooms){
        timeInMinutes = (long) Math.ceil(numberOfRooms);
        System.out.println("Game time out "+timeInMinutes+" minutes.\n");
    }

    private void readCommands() {
        String playerInput = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!playerInput.equals("quite") && isPlaying()) {
            try {
                System.out.print("Enter command:");
                playerInput = bufferedReader.readLine();
                controller.makeAction(playerInput);

            } catch (IOException e) {
                System.out.println("Invalid input");
            }
        }

        if (playerInput.equals("quite")) {
            System.out.println("\nYou lose");
            setGameStatus(false);
        }
    }


    private void setGameStatus(boolean playing){
        GameStatus status = GameStatus.getInstance();
        status.setPlaying(playing);
    }

    public boolean isPlaying(){
        GameStatus status = GameStatus.getInstance();
        return status.isPlaying();
    }

    private void terminatePrompt(){
        System.out.println("Terminate commands :");
        System.out.println("quite, restart\n");
    }

    @Override
    public String toString() {
        return "Game Driver";
    }
}
