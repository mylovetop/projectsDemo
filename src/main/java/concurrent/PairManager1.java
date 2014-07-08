package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class PairManager1 extends PairManager {

    @Override
    public void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
