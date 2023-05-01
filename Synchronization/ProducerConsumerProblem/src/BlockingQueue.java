import java.util.LinkedList;
import java.util.Queue;

//yeild() waiting to awake state,then it will fight for lock
//notfifyAll(),notify(),interruted(),wait()
//thread having wait method get called will release the aquired lock
//getState()   RUNNABLE,WAIT,Terminated
//thread.join() it will first complete the run methode of current thread then excute the main thread so blocking main thread
// we can set the priority of the thread but it is not guranteed that the same is followed by jvm
//deafult priority is 5,max is 10 and min is THREAD.MIN=1
//thread.setPriority(7)

//JVM follow two scheduling strategy:
//    1st roundrobin
//    2nd is preemtivepriority

public class BlockingQueue {

    private Queue<Integer> queue;
    private int capacity;

    public BlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean add(int item) {
        synchronized (queue) {
            while (queue.size() == capacity) {  //while is used instead of if to avoid racing condition if two thread get awoke simultaneously due to notifyMethode.
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(item);
            queue.notifyAll();
            return true;
        }

    }

    public int remove() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int item = queue.poll();
            queue.notifyAll();
            return item;
        }
    }
}
