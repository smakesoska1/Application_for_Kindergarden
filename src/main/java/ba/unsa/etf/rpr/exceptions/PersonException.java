package ba.unsa.etf.rpr.exceptions;

public class PersonException extends Exception{

    public PersonException (String msg, Exception reason) {
        super(msg, reason);
    }

    public PersonException (String msg){
        super(msg);
    }
}
