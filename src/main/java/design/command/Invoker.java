package design.command;

/**
 * Created by zdsoft on 14-6-5.
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        command.Execute();
    }
}
