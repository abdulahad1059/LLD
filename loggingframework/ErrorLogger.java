public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(Integer level, AbstractLogger nextLogger) {
        super(level, nextLogger);
    }

    @Override
    void display(String message,AbstractSubject abstractSubject) {
       abstractSubject.notifyAll(2,message);
    }
}
