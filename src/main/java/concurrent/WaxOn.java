package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-24.
 */
public class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car c) {
        this.car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffed();
            }
        } catch (InterruptedException e){
            Print.p("InterruptedException waxOn");
        }
        Print.p("waxOn task ended");
    }
}
