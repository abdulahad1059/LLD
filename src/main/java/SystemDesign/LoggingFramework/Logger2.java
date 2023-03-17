package SystemDesign.LoggingFramework;

public class Logger2 {
    private AbstractLogger2 abstractLogger2;

    public Logger2(AbstractLogger2 abstractLogger2, LoggerSubject2 loggerSubject2) {
        this.abstractLogger2 = abstractLogger2;
        this.loggerSubject2 = loggerSubject2;
    }

    private LoggerSubject2 loggerSubject2;


    
    public void info(String message) {
        this.abstractLogger2.createLog(1, message,loggerSubject2);
    }

    public void error(String message) {
        this.abstractLogger2.createLog(2, message,loggerSubject2);
    }

    public void debug(String message) {
        this.abstractLogger2.createLog(3, message,loggerSubject2);
    }
}
