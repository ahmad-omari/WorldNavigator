package GameObjects;

import java.util.TimerTask;

public class TimeHelper extends TimerTask {

    @Override
    public void run() {
        System.exit(1);
    }

    @Override
    public String toString() {
        return "Time helper";
    }
}
