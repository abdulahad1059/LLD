package SystemDesign.LoggingFramework;

import javax.swing.*;
import java.util.Arrays;

public class Application2 {
    public static void main(String args[]) {

        AbstractLogger2 debugLogger = new DebugLogger2(3, null);
        AbstractLogger2 errorLogger = new ErrorLogger2(2, debugLogger);
        AbstractLogger2 infoLogger = new InfoLogger2(1, errorLogger);
        LoggerSubject2 loggerSubject2 = new LoggerSubject2();
        loggerSubject2.addObserver(1, new InfoObserver2());
        loggerSubject2.addObserver(1, new ErrorObserver2());
        loggerSubject2.addObserver(2, new DebugObserver2());
//        loggerSubject2.m.put(2, Arrays.asList(new InfoObserver2(),new ErrorObserver2()));
//        loggerSubject2.m.put(1, Arrays.asList(new InfoObserver2()));
        Logger2 logger2=new Logger2(infoLogger,loggerSubject2);


//        logger2.error("this is an erorr");
        logger2.info("this is an info");
//        logger2.debug("this is an debug");
    }
}
