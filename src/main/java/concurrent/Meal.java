package concurrent;

/**
 * Created by zdsoft on 14-6-24.
 */
public class Meal {

    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString(){
        return "Meal " + orderNum;
    }
}
