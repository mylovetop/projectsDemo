package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zdsoft on 14-6-25.
 */
public class WaitingTask implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch l) {
        this.latch = l;
    }

    @Override
    public void run() {
        try {
            Print.p("等待执行 " + id);
            latch.await();
            Print.p("Latch barrier passed for " + this);
        } catch (InterruptedException e){
            Print.p(this + " interruptedException");
        }
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}
