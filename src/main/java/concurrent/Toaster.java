package concurrent;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Toaster implements Runnable {

    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue tq) {
        this.toastQueue = tq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        } catch (InterruptedException e){
            Print.p("toaster interruptedException");
        }
        Print.p("Toaster Off");
    }
}
