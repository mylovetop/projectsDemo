package concurrent;

/**
 * Created by zdsoft on 14-6-23.
 */
public class Joining {

    public static void main(String[] args){
        Sleeper sleepy = new Sleeper("sleepy", 1500);
//        Sleeper grumpy = new Sleeper("grumpy", 1500);

        Joiner dopey = new Joiner("dopey", sleepy);
//        Joiner doc = new Joiner("doc", grumpy);

//        grumpy.interrupt();

    }
}
