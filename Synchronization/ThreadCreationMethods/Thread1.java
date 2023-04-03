package Synchronization.ThreadCreationMethods;

public class Thread1 extends Thread {
    public void run() {
        int t = 1000;
        while (t-- != 0) {
            System.out.println("Inside thread 1");
        }
    }
}
