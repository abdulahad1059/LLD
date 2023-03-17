public abstract class AbstractLogger {
    private Integer level;
    private AbstractLogger nextLogger;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public AbstractLogger getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public AbstractLogger(Integer level, AbstractLogger nextLogger) {
        this.level = level;
        this.nextLogger = nextLogger;
    }
    public void createLog(int level,String message,AbstractSubject abstractSubject)
    {
        if(this.level<=level)
        {
            display(message,abstractSubject);
        }
        if(this.nextLogger!=null)
        {
            this.nextLogger.createLog(level,message,abstractSubject);
        }
    }
     abstract void display(String message,AbstractSubject abstractSubject);
}
