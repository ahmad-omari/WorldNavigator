package GameObjects;

public class GameStatus {
    public static final GameStatus instance = new GameStatus();
    private boolean Playing;

    private GameStatus(){}

    public static GameStatus getInstance(){
        return instance;
    }

    public boolean isPlaying() {
        return Playing;
    }

    public synchronized void setPlaying(boolean playing) {
        Playing = playing;
    }

    @Override
    public String toString() {
        return "Game status";
    }
}
