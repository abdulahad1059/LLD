public class Main {
    public static void main(String[] args) {

        String lock1="lock1";
        String lock2="lock2";
        Thread t1=new Thread(()->{
            synchronized (lock1)
            {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2)
                {
                    System.out.println("Aquired both the lock");
                }
            }
        },"Thread1");

        Thread t2=new Thread(()->{
            synchronized (lock2)
            {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1)
                {
                    System.out.println("Aquired both the lock");
                }
            }
        },"Thread1");
        System.out.println("Hello world!");
        t1.start();
        t2.start();
    }
}