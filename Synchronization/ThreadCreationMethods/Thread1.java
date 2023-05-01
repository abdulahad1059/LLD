package Synchronization.ThreadCreationMethods;

public class Thread1 extends Thread {
    public Thread1(String name)
    {
        super(name);
    }
    public void run() {
        int t = 5;
        while (t-- != 0) {
            System.out.println("Inside thread 1 "+Thread.currentThread().getName());
        }
    }
}
