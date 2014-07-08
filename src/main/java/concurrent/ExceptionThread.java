package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
