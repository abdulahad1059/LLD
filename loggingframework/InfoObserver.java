public class InfoObserver extends AbstractObserver {
    @Override
    void display(String message) {
        System.out.println("Info:" + message);
    }
}
