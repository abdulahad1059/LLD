public class Logger {
    private AbstractLogger abstractLogger;
    private AbstractSubject abstractSubject;

    public AbstractLogger getAbstractLogger() {
        return abstractLogger;
    }

    public void setAbstractLogger(AbstractLogger abstractLogger) {
        this.abstractLogger = abstractLogger;
    }

    void infoLogger(String message) {
        this.abstractLogger.createLog(1, message,this.abstractSubject);
    }

    void errorLogger(String message) {
        this.abstractLogger.createLog(2, message,this.abstractSubject);
    }

    void debugLogger(String message) {
        this.abstractLogger.createLog(3, message,this.abstractSubject);
    }

    public AbstractSubject getAbstractSubject() {
        return abstractSubject;
    }

    public void setAbstractSubject(AbstractSubject abstractSubject) {
        this.abstractSubject = abstractSubject;
    }

    public Logger(AbstractLogger abstractLogger, AbstractSubject abstractSubject) {
        this.abstractLogger = abstractLogger;
        this.abstractSubject = abstractSubject;
    }


}
