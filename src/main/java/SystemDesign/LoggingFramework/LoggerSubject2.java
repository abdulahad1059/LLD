package SystemDesign.LoggingFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerSubject2 {
    Map<Integer, List<LogObserver2>> m=new HashMap<>();
    void addObserver(int level,LogObserver2 logObserver)
    {
        List<LogObserver2> l=m.getOrDefault(level,new ArrayList<>());
        l.add(logObserver);
        m.put(level,l);
    }
    void notifyAllObserver(int level,String message)
    {
        for(Map.Entry<Integer, List<LogObserver2>> temp:m.entrySet())
        {
            if(temp.getKey()==level)
            {
                temp.getValue().stream().forEach(obj->{
                    obj.notifyMe(message);
                });
            }

        }
    }
}
