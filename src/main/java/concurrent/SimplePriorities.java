package concurrent;

/**
 * Created by zdsoft on 14-6-23.
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(this.priority);
        while (true){
            for (int i = 0; i < 10000; i++){
                d += (Math.PI + Math.E) / (double)i;
                if (i % 10000 == 0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0)return;
        }

    }
}
