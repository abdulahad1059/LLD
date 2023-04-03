package Synchronization.ThreadCreationMethods;

public class MainClass {
    public static void main(String args[]) {


//        Thread1 thread1 = new Thread1();
//        Thread2 thread2 = new Thread2();
//        thread1.start();
//        thread2.start();

        Thread3 thread3 = new Thread3();
        Thread th3 = new Thread(thread3);

        Thread4 thread4 = new Thread4();
        Thread th4 = new Thread(thread4);
        th3.start();
        th4.start();

    }
}
