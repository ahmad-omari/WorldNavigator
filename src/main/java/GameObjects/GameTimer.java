package GameObjects;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class GameTimer {
    private TimerTask task;
    private Timer timer;

    private long timeLimit;

    public GameTimer(){
        task = new TimeHelper();
        timer = new Timer();
    }

    public void setTimeInMinutes(long minutes){
        timeLimit = TimeUnit.MINUTES.toMillis(minutes);
    }

    public void start() {
        timer.schedule(task,timeLimit);
    }

    public void stop(){
        timer.cancel();
    }

    @Override
    public String toString() {
        return "Game timer";
    }
}
