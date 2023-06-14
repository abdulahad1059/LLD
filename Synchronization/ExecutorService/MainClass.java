package Synchronization.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static void main() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(3);
            SequenceGenerator sequenceGenerator = new SequenceGenerator(3);
            executorService.submit(new ExecutorThread(0, sequenceGenerator));
            executorService.submit(new ExecutorThread(1, sequenceGenerator));
            executorService.submit(new ExecutorThread(2, sequenceGenerator));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null)
                executorService.shutdown();
        }
    }

}
