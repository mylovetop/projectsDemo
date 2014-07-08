package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-24.
 */
public class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}
