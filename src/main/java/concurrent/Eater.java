package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Eater implements Runnable {

    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast t = finishedQueue.take();
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED){
                    Print.p(">>>Error: " + t);
                } else {
                    Print.p("Chomp! " + t);
                }
            }
        } catch (InterruptedException e){
            Print.p("Eater interruptedException");
        }
        Print.p("Eater Off");
    }
}
