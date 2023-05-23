package Synchronization;

public class SingeltonDoubleLocking {
    private static volatile SingeltonDoubleLocking singeltonDoubleLocking = null;

    private SingeltonDoubleLocking() {
    }

    public static SingeltonDoubleLocking getSingeltonDoubleLocking() {

        if (singeltonDoubleLocking == null) {
            synchronized (SingeltonDoubleLocking.class) {
                if (singeltonDoubleLocking == null)
                    singeltonDoubleLocking = new SingeltonDoubleLocking();
            }
        }

        return singeltonDoubleLocking;
    }
}
