package Synchronization.ThreadCreationMethods;

public class Thread4 implements Runnable {
    public void run() {
        int t = 1000;
        while (t-- != 0) {
            System.out.println("Inside thread 4");
        }
    }
}
