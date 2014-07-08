package design.decorator;

/**
 * Created by zdsoft on 14-6-4.
 */
public abstract class Decorator extends Component {

    protected Component component;

    public void SetComponent(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        if (null != component){
            component.operation();
        }
    }
}
