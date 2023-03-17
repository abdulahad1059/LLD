package SlidingWindow;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SlidingWindow implements RateLimitter {

    private Long timeWindow;
    private Integer bucketCap;
    Queue<Long> queue;

    public SlidingWindow(Long timeWindow, Integer bucketCap) {
        this.timeWindow = timeWindow;
        this.bucketCap = bucketCap;
        queue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public boolean grantAccess() {
        updateQueue();
        if (queue.size() < bucketCap) {
            queue.add(1L);
            return true;
        }
        return false;
    }

    void updateQueue() {
        if (queue.isEmpty())
            return;
        long time = System.currentTimeMillis();
        long d = time - queue.peek();
        while (!queue.isEmpty() && d >= this.timeWindow) {
            queue.poll();
            if (queue.isEmpty())
                break;
            d = time - queue.peek();
        }
    }
}
