package concurrent;

/**
 * Created by zdsoft on 14-6-23.
 */
public class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " join 开始");
            sleeper.join();
            System.out.println(getName() + " join 继续");
        } catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(getName() + " join completed");
    }
}
