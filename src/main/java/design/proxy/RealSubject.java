package design.proxy;

/**
 * Created by zdsoft on 14-6-4.
 */
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.print("真实的请求");
    }
}
