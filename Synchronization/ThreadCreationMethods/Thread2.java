package Synchronization.ThreadCreationMethods;

public class Thread2 extends Thread {
    public Thread2(String name)
    {
        super(name);
    }
    public void run() {
        int t = 5;
        while (t-- != 0) {
            System.out.println("Inside thread 2 "+Thread.currentThread().getName());
        }
    }
}
