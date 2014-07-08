package design.decorator;

/**
 * Created by zdsoft on 14-6-4.
 */
public class Main {

    public static void main(String[] args){
        System.out.print("Main\n");
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA a = new ConcreteDecoratorA();
        ConcreteDecoratorB b = new ConcreteDecoratorB();

        a.SetComponent(c);
        b.SetComponent(a);

        b.operation();
    }
}
