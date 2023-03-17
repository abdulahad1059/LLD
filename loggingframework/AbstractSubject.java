import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractSubject {
    Map<Integer, List<AbstractObserver>> m = new HashMap<>();

    void addObserver(int level, AbstractObserver abstractObserver) {
        List<AbstractObserver> temp = m.getOrDefault(level, new ArrayList<>());
        temp.add(abstractObserver);
        m.put(level, temp);
    }

    void notifyAll(int level, String message) {
        for (Map.Entry<Integer, List<AbstractObserver>> t : m.entrySet()) {
            if (t.getKey() == level) {
                for (AbstractObserver abstractObserver : m.get(level)) {
                    abstractObserver.display(message);
                }
            }
        }
    }
}
