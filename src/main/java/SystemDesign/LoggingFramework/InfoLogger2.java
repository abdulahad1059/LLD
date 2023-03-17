package SystemDesign.LoggingFramework;

public class InfoLogger2 extends AbstractLogger2 {

    public InfoLogger2(int level, AbstractLogger2 nextLogger) {
        super(level, nextLogger);
    }

    @Override
    public void display(String message,LoggerSubject2 loggerSubject2) {

        loggerSubject2.notifyAllObserver(1,message);
    }
}
