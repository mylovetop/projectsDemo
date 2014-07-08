package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Interrupting {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void test(Runnable r) throws InterruptedException{
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupting send to : " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception{
//        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
    }
}
