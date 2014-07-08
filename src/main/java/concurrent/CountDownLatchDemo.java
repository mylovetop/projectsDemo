package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zdsoft on 14-6-25.
 */
public class CountDownLatchDemo {

    static final int SIZE = 100;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++){
            executorService.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++){
            executorService.execute(new TaskPortion(latch));
        }
        Print.p("Launched all tasks");
        executorService.shutdown();
    }
}
