package concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * Created by zdsoft on 14-6-24.
 */
public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new thread");
        Thread t = new Thread(r);

        System.out.println("created " + t);

        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
