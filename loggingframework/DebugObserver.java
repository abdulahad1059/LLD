public class DebugObserver extends AbstractObserver{
    @Override
    void display(String message) {
        System.out.print("Debug:"+message);
    }
}
