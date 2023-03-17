package SystemDesign.LoggingFramework;

public class DebugLogger2 extends AbstractLogger2 {
    public DebugLogger2(int level, AbstractLogger2 nextLogger) {
        super(level, nextLogger);
    }

    @Override
    void display(String message,LoggerSubject2 loggerSubject2) {
        loggerSubject2.notifyAllObserver(3,message);
    }
}
