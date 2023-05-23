import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class BlockingQueue {
    private Queue<Integer> q = new LinkedList<>();
    private final Integer capacity = 10;

    void add(int c) {
        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            q.add(c);
            q.notifyAll();
        }
    }

    Boolean remove() {
        synchronized (q) {
            while (q.size() == 0) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Integer t=q.poll();
            q.notifyAll();
            return true;
        }
    }
}

public class Main {
    public static void main(String[] args) {


    }
}