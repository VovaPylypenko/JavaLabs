package kpi.lab3;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Logger2 {
    private Logger logger = Logger.getLogger(Main.class);

     Logger2(){
         DOMConfigurator.configure("log4j.xml");
     }

    public Logger getLogger() {
        return logger;
    }
}
