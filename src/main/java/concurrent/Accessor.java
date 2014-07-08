package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Accessor implements Runnable {

    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "# " + id + " : " + ThreadLocalVariableHolder.get();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
}
