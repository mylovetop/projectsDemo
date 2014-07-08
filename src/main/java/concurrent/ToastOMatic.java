package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-24.
 */
public class ToastOMatic {

    public static void main(String[] args) throws Exception{
        ToastQueue dryQueue = new ToastQueue(),
                buttererQueue = new ToastQueue(),
                finishQueue = new ToastQueue();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, buttererQueue));
        exec.execute(new Jammer(buttererQueue, finishQueue));
        exec.execute(new Eater(finishQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();


    }
}
