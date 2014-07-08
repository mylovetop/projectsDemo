package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class SynchronizedBlocked implements Runnable {

    public synchronized void f(){
        while (true){
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(){
            public void run(){
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
