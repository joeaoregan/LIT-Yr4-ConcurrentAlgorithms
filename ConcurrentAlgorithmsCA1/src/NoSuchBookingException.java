/*
    Hotel Room Booking System.
    
    NoSuchBookingException.java
    
    Joe O'Regan
    K00203642
    
    26/10/2017
    
    File included as part of assignment
*/

@SuppressWarnings("serial")
public class NoSuchBookingException extends Exception{
    public NoSuchBookingException (String bookingRef) {
    	super("There is no booking with reference " + bookingRef);
    }
}
