package design.command;

/**
 * Created by zdsoft on 14-6-5.
 */
public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void Execute();
}
