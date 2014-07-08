package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Chef implements Runnable {

    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal != null)
                        wait();
                }
                if (++count == 10){
                    Print.p("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                Print.p("Order up!");
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e){
            Print.p("chef InterruptedException");
        }

    }
}
