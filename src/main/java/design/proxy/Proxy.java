package design.proxy;

/**
 * Created by zdsoft on 14-6-4.
 */
public class Proxy extends Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        if (null == realSubject){
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
