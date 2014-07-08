package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zdsoft on 14-6-23.
 */
public class CacheThreadPool {

    public static void main(String[] args){
        ExecutorService exce = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exce.execute(new LiftOff());
        exce.shutdown();
    }
}
