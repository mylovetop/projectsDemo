package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class PairManager2 extends PairManager {

    @Override
    public void increment() {
        Pair tmp;
        synchronized (this){
            p.incrementY();
            p.incrementX();
            tmp = getPair();
        }
        store(tmp);

    }
}
