package concurrent;

import java.util.concurrent.BlockingQueue;

/**
 * Created by zdsoft on 14-6-24.
 */
public class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        this.rockets = queue;
    }

    public void add(LiftOff lo){
        try {
            rockets.put(lo);
        } catch (InterruptedException e){
            Print.p("Interrupted during put()");
        }
    }



    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e){
            Print.p("walking from take()");
        }
        Print.p("Exiting LiftOffRunner");
    }
}
