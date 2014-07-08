package design.strategy;

/**
 * Created by zdsoft on 14-6-6.
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface(){
        strategy.algorithmInterface();
    }
}
