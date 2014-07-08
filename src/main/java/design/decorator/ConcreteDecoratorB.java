package design.decorator;

/**
 * Created by zdsoft on 14-6-4.
 */
public class ConcreteDecoratorB extends Decorator {
    @Override
    public void operation() {
        super.operation();
        added();

    }

    private void added(){
        System.out.print("具体装饰对象B操作");
    }
}
