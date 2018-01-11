/*
    Hotel Room Booking System.
    
    JoeTest.java
    
    Joe O'Regan
    K00203642
    
    11/01/2018
    
    This class is used to test the Hotel Room Booking System
*/

public class JoeTest {

    public static void main(String [] args) {
    	System.out.println("Joe O'Regan\nK00203642\n");
    	System.out.println("Concurrent Algorithms Assignment 1\nHotel Booking\n");

    	//int[] hotel1Rooms = {1,2,3}; 
    	int[] hotel2Rooms = {2,4,6,8}; 

    	//System.out.println("Hotel 1:\n\n");
    	//Hotel hotel1 = new Hotel(hotel1Rooms);
    	Hotel hotel2 = new Hotel(hotel2Rooms);    

    	//hotel1.showRooms();

    	//System.out.println("Hotel 1:\n\n");
    	
    	hotel2.showRooms("2");   	
    	
    	//boolean bookRoom(String bookingRef, int[] days, int roomNum)
    	//System.out.println("\nBooking 1:");
    	//int[] daystobook = {1,2,4};
    	//hotel1.bookRoom("Ref1", daystobook, 1);
    	//hotel1.bookRoom("Ref1b", daystobook, 4);									// Check for valid room number

    	System.out.println("\nTEST: bookRoom()\n");

    	System.out.println("Booking 2:");
    	int[] daystobook2 = {3,4,5,6};
    	int[] daystobook2b = {1,2,3};
    	hotel2.bookRoom("Ref2", daystobook2, 2);									// Try booking room 2 for days 3,4,5,6 - Should work
    	
    	//hotel2.updateBooking("Ref2", daystobook2b, 2);
    	
    	// updateBooking()
    	System.out.println("\nTEST: updateBooking() 1\n");
    	// Should fail on days
    	try {
    		hotel2.updateBooking("Ref2", daystobook2b, 2);							// Should be fine on booking reference "Ref2", but fail on day 3
		} catch (NoSuchBookingException e) {
			e.printStackTrace();
		}

    	System.out.println("\nTEST: updateBooking() 2\n");
    	// Should work
    	int[] daystobookWorks = {1,2};
    	try {
    		hotel2.updateBooking("Ref2",daystobookWorks , 2);						// Should be fine on booking reference "Ref2",and the selected days
		} catch (NoSuchBookingException e) {
			e.printStackTrace();
		}

    	System.out.println("\nTEST: updateBooking() 3\n");
    	// Should fail "Ref3"
    	try {
    		hotel2.updateBooking("Ref3", daystobook2b, 2);							// Should fail on booking reference "Ref3"
		} catch (NoSuchBookingException e) {
			e.printStackTrace();
		}

    	
    	
    	// Check for unique booking references
    	System.out.println("\nTEST: unique booking entered\n");
    	hotel2.bookRoom("Ref2", daystobook2, 2);									// Try booking room 2 for days 3,4,5,6 - Should fail on booking ref "Ref2" repeating
 	
    	// Check a booking exists
    	if(hotel2.checkBookingOnList("Ref2")) 
    		System.out.println("Check Booking: yes for Ref2");						// Should have a booking ref "Ref2"
    	else
    		System.out.println("Check Booking: No for Ref2");

    	if(hotel2.checkBookingOnList("Refx")) 
    		System.out.println("Check Booking: Yes for Refx");
    	else
    		System.out.println("Check Booking: No for Refx");						// Should not have a booking ref "Refx"

    	hotel2.displayAllRoomBookings("2");

    	System.out.println("\nTEST: cancelBooking()\n");
    	
    	System.out.println("\nBooking 3:");
    	int[] daystobook3 = {1,3,5,7};												// Try booking room 2 for days 1,3,5,7 - Should fail
    	hotel2.bookRoom("Ref3", daystobook3, 2);

    	hotel2.displayAllRoomBookings("2");
    	
    	/*
    	try {
			hotel2.cancelBooking("RandomReferenceNumber");							// Should fail on booking reference
		} catch (NoSuchBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NoSuchBookingException works\n");
		}
    	*/
 
    	try {
			hotel2.cancelBooking("Ref2");											// Should be fine on booking reference "Ref2"
		} catch (NoSuchBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NoSuchBookingException works\n");
		}
    	
    	System.out.println("\nBooking 4:");
    	hotel2.bookRoom("Ref4", daystobook3, 8);									// Try booking room 8 for days 1,3,5,7 - Should succeed
    	
    	hotel2.displayAllRoomBookings("2");
    	
    	// TEST: cancelBooking()
    	System.out.println("\nTEST: cancelBooking(\"Ref4\") - Should work");
    	try {
			hotel2.cancelBooking("Ref4");											// Should be fine on booking reference "Ref2"
		} catch (NoSuchBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NoSuchBookingException works\n");
		}

    	System.out.println("TEST: cancelBooking(\"Ref5\") - Should fail");
    	try {
			hotel2.cancelBooking("Ref5");											// Should be fine on booking reference "Ref2"
		} catch (NoSuchBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NoSuchBookingException works\n");
		}

    	hotel2.displayAllRoomBookings("2");

    }
}
