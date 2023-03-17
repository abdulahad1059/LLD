package AccessToken;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LeakyBucket implements RateLimitter {

    private AtomicInteger currentCapacity;
    private AtomicLong lastUpdatedAt;
    private Integer cap;
    private Integer rate;

    public LeakyBucket(int cap, int rate) {
        this.currentCapacity = new AtomicInteger(cap);
        this.lastUpdatedAt = new AtomicLong(System.currentTimeMillis());
        this.rate = rate;
        this.cap = cap;
    }

    void refreshToken() {
        Long temp = ((System.currentTimeMillis() - lastUpdatedAt.get()) / 1000) * rate;
        this.currentCapacity.set((int) Math.min(temp + this.currentCapacity.get(), cap));
        this.lastUpdatedAt.set(System.currentTimeMillis());
    }

    @Override
    public boolean grantAccess() {
        refreshToken();
        if (this.currentCapacity.get() > 0) {
            this.currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }
}
