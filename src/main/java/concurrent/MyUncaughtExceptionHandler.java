package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught: " + e);
    }
}
