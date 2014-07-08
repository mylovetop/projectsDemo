package concurrent;

/**
 * Created by zdsoft on 14-6-23.
 */
public class BasicThreads {

    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
