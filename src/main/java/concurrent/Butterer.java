package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Butterer implements Runnable {

    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast t = dryQueue.take();
                t.butter();
                Print.p(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e){
            Print.p("Butterer interruptedException");
        }
        Print.p("Butterer off");
    }
}
