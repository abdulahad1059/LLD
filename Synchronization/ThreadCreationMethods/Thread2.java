package Synchronization.ThreadCreationMethods;

public class Thread2 extends Thread {
    public void run() {
        int t = 1000;
        while (t-- != 0) {
            System.out.println("Inside thread 2");
        }
    }
}
