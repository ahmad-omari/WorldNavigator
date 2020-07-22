package GameObjects;

import java.util.TimerTask;

public class TimeHelper extends TimerTask {

    @Override
    public void run() {
        System.out.println("\nGame time over, you lose");
        System.exit(1);
    }

    @Override
    public String toString() {
        return "Time helper";
    }
}
