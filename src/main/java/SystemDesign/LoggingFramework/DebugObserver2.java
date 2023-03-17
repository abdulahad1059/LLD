package SystemDesign.LoggingFramework;

public class DebugObserver2 implements LogObserver2 {
    @Override
    public void notifyMe(String message) {
        System.out.print("Debug:  " + message);
    }
}
