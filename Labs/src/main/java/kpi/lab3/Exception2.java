package kpi.lab3;

public class Exception2 extends Exception {

    public Exception2() {
        super();
    }

    public Exception2(String message, Logger2 logger) {
        super(message);
        logger.getLogger().error("Exception: " + message);
    }
}
