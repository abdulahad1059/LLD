package Synchronization;

public class SingletonThreadSafe {
    //volatile banane se hr thread ke pass same singletonThreadSafe instance rhega.
    private volatile static SingletonThreadSafe singletonThreadSafe = null;

    private SingletonThreadSafe() {

    }

    public static SingletonThreadSafe getInstance() {
        if (singletonThreadSafe == null) {
            synchronized (SingletonThreadSafe.class) {
                if (singletonThreadSafe == null)    //double checking
                    singletonThreadSafe = new SingletonThreadSafe();
            }
        }
        return singletonThreadSafe;
    }
}
