package concurrent;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zdsoft on 14-6-24.
 */
public class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read():");
            in.read();
        } catch (IOException e){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted form block i/o");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
