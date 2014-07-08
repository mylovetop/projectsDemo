package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zdsoft on 14-6-23.
 */
public class SleepingDemo {

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
