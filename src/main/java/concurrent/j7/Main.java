package concurrent.j7;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by zdsoft on 14-6-27.
 */
public class Main {

    public static void main(String[] args){
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(1000);

        Task task = new Task(products, 0, products.size(), 0.20);

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        do {
            System.out.printf("Main: Thread Count : %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal : %d\n", pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        } while (!task.isDone());


    }
}
