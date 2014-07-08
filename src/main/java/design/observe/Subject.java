package design.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdsoft on 14-6-4.
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
}
