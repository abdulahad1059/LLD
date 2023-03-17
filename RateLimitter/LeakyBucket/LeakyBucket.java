package LeakyBucket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucket implements RateLimitter {

    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

    @Override
    public boolean grantAccess() {
        if (queue.remainingCapacity() > 0) {
            queue.add(1);
            return true;
        } else {
            return false;
        }
    }
}
