public class InfoLogger extends AbstractLogger{
    public InfoLogger(Integer level, AbstractLogger nextLogger) {
        super(level, nextLogger);
    }

    @Override
    void display(String message,AbstractSubject abstractSubject) {
        abstractSubject.notifyAll(1,message);
    }
}
