package GameObjects;

import java.util.Timer;
import java.util.TimerTask;

public class PlayersWaiting {
    private Timer timer;
    private TimerTask timerTask;
    private static int timerSeconds;

    public PlayersWaiting(){
        timer = new Timer();
        timerSeconds = 60;
        makeTask();
        start();
    }

    private void makeTask() {
        timerTask = new TimeHelper(){
            @Override
            public void run() {
                timerSeconds--;
                if (timerSeconds <= 1) {
                    timerTask.cancel();
                }
            }
        };

    }

    public void start(){
        timer.scheduleAtFixedRate(timerTask,1000,1000);
    }

    public static int getTimerSeconds() {
        return timerSeconds;
    }

}
