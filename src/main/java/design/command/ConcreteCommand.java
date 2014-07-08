package design.command;

/**
 * Created by zdsoft on 14-6-5.
 */
public class ConcreteCommand extends Command {

    @Override
    public void Execute() {
        receiver.Action();
    }

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }
}
