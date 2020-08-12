package GameObjects;

public class PlayersCounter {
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        PlayersCounter.count = count;
    }

    public static void incrementCount() {
        PlayersCounter.count = count+1;
    }
}
