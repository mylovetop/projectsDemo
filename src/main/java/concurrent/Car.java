package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Car {

    private boolean waxOn = false;

    public synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed(){
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException{
        while (waxOn == false)
            wait();
    }

    public synchronized void waitForBuffed() throws InterruptedException{
        while (waxOn == true)
            wait();
    }
}
