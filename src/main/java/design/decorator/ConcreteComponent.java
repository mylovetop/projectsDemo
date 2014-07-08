package design.decorator;

/**
 * Created by zdsoft on 14-6-4.
 */
public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("具体的操作对象");
    }
}
