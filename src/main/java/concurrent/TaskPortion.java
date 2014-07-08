package concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-25.
 */
public class TaskPortion implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch l) {
        this.latch = l;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e){

        }
    }

    public void doWork() throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        Print.p(this + " completed!");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}
