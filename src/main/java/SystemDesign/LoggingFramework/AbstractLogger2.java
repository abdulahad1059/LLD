package SystemDesign.LoggingFramework;

public abstract class AbstractLogger2 {
    private int level;
    private AbstractLogger2 nextLogger;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public AbstractLogger2 getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(AbstractLogger2 nextLogger) {
        this.nextLogger = nextLogger;
    }

    public AbstractLogger2(int level, AbstractLogger2 nextLogger) {
        this.level = level;
        this.nextLogger = nextLogger;
    }

    void createLog(int level, String message,LoggerSubject2 loggerSubject2) {
        if (this.level <= level) {
            display(message,loggerSubject2);
        }
        if (this.nextLogger != null) {
            this.nextLogger.createLog(level, message,loggerSubject2);
        }
    }

    abstract void display(String message,LoggerSubject2 loggerSubject2);
}
