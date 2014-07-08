package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-23.
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try {
            while (countDown-->0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.err.println(e);
        }
    }
}
