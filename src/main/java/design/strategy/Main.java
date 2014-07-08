package design.strategy;



/**
 * Created by zdsoft on 14-6-6.
 */
public class Main {

    public static void main(String[] args){

        Context context;

        ConcreteStrategyA a = new ConcreteStrategyA();
        ConcreteStrategyB b = new ConcreteStrategyB();

        context =  new Context(a);
        context.contextInterface();

        context = new Context(b);
        context.contextInterface();


    }
}
