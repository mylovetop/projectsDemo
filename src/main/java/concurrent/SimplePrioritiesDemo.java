package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zdsoft on 14-6-23.
 */
public class SimplePrioritiesDemo {

    public static void main(String[] args){
        ExecutorService exce = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exce.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exce.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exce.shutdown();
    }
}
