package Synchronization.ExecutorService;

public class SequenceGenerator {
    private int number = 0;
    private int totalNumber=10;
    private int totalNoOFThread = 3;

    public SequenceGenerator(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public void printNumber(int result) {
        synchronized (this) {
            while (number < totalNumber) {
                while (number % totalNoOFThread != result) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(number);
                number++;
                notifyAll();
            }
        }
    }
}
