package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zdsoft on 14-6-24.
 */
public class CaptureUncaughtException {

    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread2());
    }
}
