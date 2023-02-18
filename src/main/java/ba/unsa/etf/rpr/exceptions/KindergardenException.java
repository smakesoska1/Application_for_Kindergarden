package ba.unsa.etf.rpr.exceptions;

/**
 * custom exception KindergardenException for application
 */

public class KindergardenException extends Exception{

    public KindergardenException(String msg, Exception reason) {
        super(msg, reason);
    }

    public KindergardenException(String msg){
        super(msg);
    }
}
