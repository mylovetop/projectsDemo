package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class SyncObject {

    public static void main(String[] args){
        final DualSynch ds = new DualSynch();
        new Thread(){
            @Override
            public void run() {
                ds.f();
            }
        }.start();

        ds.g();
    }
}
