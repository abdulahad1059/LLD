package SystemDesign.LoggingFramework;

public class InfoObserver2 implements LogObserver2{
    @Override
    public void notifyMe(String message) {
        System.out.print("Info:   "+message);
    }
}
