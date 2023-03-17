package SystemDesign.LoggingFramework;

public class ErrorLogger2 extends AbstractLogger2 {
    public ErrorLogger2(int level, AbstractLogger2 nextLogger) {
        super(level, nextLogger);
    }

    @Override
    void display(String message,LoggerSubject2 subject2) {

        subject2.notifyAllObserver(2,message);
    }
}
