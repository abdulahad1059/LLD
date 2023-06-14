package Synchronization.ExecutorService;

public class ExecutorThread implements Runnable {

    private int result;
    private SequenceGenerator sequenceGenerator;

    public ExecutorThread(int result, SequenceGenerator sequenceGenerator) {
        this.result = result;
        this.sequenceGenerator = sequenceGenerator;
    }

    public void run() {
        this.sequenceGenerator.printNumber(this.result);
    }
}
