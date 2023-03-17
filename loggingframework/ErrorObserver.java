public class ErrorObserver extends AbstractObserver {
    @Override
    void display(String message) {
        System.out.println("Error:" + message);
    }
}
