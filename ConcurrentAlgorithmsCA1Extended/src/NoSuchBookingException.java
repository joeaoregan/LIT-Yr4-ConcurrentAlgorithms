/*
    Hotel Room Booking System (Extended).
    
    NoSuchBookingException.java
    
    Joe O'Regan
    K00203642
    
    11/01/2018
    
    File included as part of assignment
*/

@SuppressWarnings("serial")
public class NoSuchBookingException extends Exception{
    public NoSuchBookingException (String bookingRef) {
    	super("There is no booking with reference " + bookingRef);
    }
}
