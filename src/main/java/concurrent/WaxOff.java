package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-24.
 */
public class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car c) {
        this.car = c;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                car.waitForWaxing();
                System.out.println("Wax Off!");
                Print.p("开始休眠");
                TimeUnit.MILLISECONDS.sleep(200);
                Print.p("结束休眠");
                car.buffed();
            }
        } catch (InterruptedException e){
            Print.p("InterruptedException waxOff");
        }
        Print.p("WaxOff task end");
    }
}
