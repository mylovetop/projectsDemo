package concurrent;

/**
 * Created by zdsoft on 14-6-23.
 */
public class MoreBasicThreads {

    public static void main(String[] args){
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
    }
}
