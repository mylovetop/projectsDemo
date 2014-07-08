package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zdsoft on 14-6-24.
 */
public class BlockedMutex {
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
    }

    public void f(){
        try {
            lock.lockInterruptibly();
            System.out.println("lock in f()");
        } catch (InterruptedException e){
            System.out.println("lock interrupted form f()");
        }
    }
}
