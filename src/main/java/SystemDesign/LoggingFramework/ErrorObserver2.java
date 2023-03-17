package SystemDesign.LoggingFramework;

public class ErrorObserver2 implements LogObserver2{
    @Override
    public void notifyMe(String message) {
        System.out.print("Error: "+message);
    }
}
