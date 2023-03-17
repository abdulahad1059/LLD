public class DebugLogger extends AbstractLogger{
    public DebugLogger(Integer level, AbstractLogger nextLogger) {
        super(level, nextLogger);
    }

    @Override
    void display(String message,AbstractSubject abstractSubject) {
        abstractSubject.notifyAll(3,message);
    }
}
