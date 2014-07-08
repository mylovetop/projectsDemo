package concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-24.
 */
public class ThreadLocalVariableHolder {

    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random rand = new Random(47);
        protected synchronized Integer initialValue(){
            return rand.nextInt(100);
        }
    };

    public static void increment(){
        value.set(value.get() + 1);
    }

    public static int get(){
        return value.get();
    }

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 1; i++){
            exec.execute(new Accessor(i));
        }
        TimeUnit.MILLISECONDS.sleep(3);
        exec.shutdown();
    }
}
