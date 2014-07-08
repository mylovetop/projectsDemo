package concurrent;

import java.util.concurrent.Callable;

/**
 * Created by zdsoft on 14-6-23.
 */
public class TaskWithResult implements Callable<String> {

    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
