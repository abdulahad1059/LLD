package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer, SlidingWindow> bucket = new HashMap<>();

    void addBucket(int id) {
        bucket.put(id, new SlidingWindow(10L, 10));
    }

    void accessApplication(int id) {
        if (bucket.get(id).grantAccess()) {
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }

}
