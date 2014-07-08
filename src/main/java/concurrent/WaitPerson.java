package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal == null){
                        Print.p("等待");
                        wait();
                    }

                }
                Print.p("WaitPerson got " + restaurant.meal);
                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e){
            Print.p("WaitPerson interrupted");
        }
    }
}
