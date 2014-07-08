package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Jammer implements Runnable {

    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast t = butteredQueue.take();
                t.jam();
                Print.p(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e){
            Print.p("Jammer interruptedException");
        }
        Print.p("Jammer Offf");
    }
}
