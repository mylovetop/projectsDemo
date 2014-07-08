package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zdsoft on 14-6-24.
 */
public class ExceptionThreadDemo {

    public static void main(String[] args){
        try{
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException e){
            System.out.println("Exception has handled");
        }

    }
}
