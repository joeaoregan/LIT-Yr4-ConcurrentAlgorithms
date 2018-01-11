/*
    Hotel Room Booking System (Extended).
    
    JoeTest.java
    
    Joe O'Regan
    K00203642
    
    11/01/2018
    
    This class is used to test the Extended Hotel Room Booking System
*/
public class JoeExtendedTest {

    public static void main(String [] args) {
    	System.out.println("Joe O'Regan\nK00203642\n");
    	System.out.println("Concurrent Algorithms Assignment 1\nHotel Booking EXTENDED\n");

    	System.out.println("Hotel 1:");
    	int[] hotel1Rooms = {1,2,3}; 
    	Hotel hotel1 = new Hotel(hotel1Rooms);
    	hotel1.showRooms("1");
    	
    	System.out.println("\nEXTENDED Booking 1: Test bookRooms()\n");
    	int[] roomsToBook = {1,2};
    	int[] daysToBook = {3,4,5,6};
    	hotel1.bookRooms("Ref1", daysToBook, roomsToBook);							// Try booking rooms 1 and 2 for days 3,4,5,6 - Should work
    	

    	System.out.println("\nEXTENDED Booking 2: Test roomsBooked()");
    	/*
    	// Room(s) don't exist in hotel
    	int[] roomsToBook2 = {2,3,4,5};
    	int[] daysToBook2 = {6,7,8};
    	hotel1.bookRooms("Ref2", daysToBook2, roomsToBook2);
    	
    	int[] roomsToBook2 = {2,3,4};
    	int[] daysToBook2 = {6,7,8};
    	hotel1.bookRooms("Ref2", daysToBook2, roomsToBook2);
    	*/
    	int[] roomsToBook2 = {2,3};
    	int[] daysToBook2 = {5,6,7,8};
    	hotel1.bookRooms("Ref2", daysToBook2, roomsToBook2);    					// Should not create 

    	System.out.println("\nEXTENDED Booking 3: Test cancelBooking()");
    	
    	try {
			hotel1.cancelBooking("Ref1");											// Should be fine on booking reference "Ref2"
		} catch (NoSuchBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NoSuchBookingException works\n");
		}
    	
    	// Check booking removed
    	System.out.println("\nEXTENDED Booking 3b: Test checkBookingOnList()");
    	if (hotel1.checkBookingOnList("Ref1"))
    		System.out.println("Ref1 exits");
    	else
    		System.out.println("Ref1 does not exit");
   		

    	System.out.println("\nEXTENDED Booking 4: Test updateBooking()");
    	int[] roomsToBook4 = {2,3};
    	int[] daysToBook4 = {5,6,7,8};
    	hotel1.bookRooms("Ref2", daysToBook4, roomsToBook4);    							// Should not create 

    	int[] roomsToBook4b = {1,2};
    	int[] daysToBook4b = {8,9};
    	// updateBooking()
    	System.out.println("\nTEST: updateBooking() 1\n");
    	// Should fail on days
    	try {
    		hotel1.updateBooking("Ref2", daysToBook4b, roomsToBook4b);						// Should be fine on booking reference "Ref2", but fail on day 3
		} catch (NoSuchBookingException e) {
			e.printStackTrace();
		}

    	System.out.println("\nTEST: updateBooking() 2\n");
    	// Should work
    	int[] roomsToBook4c = {1,2};
    	int[] daysToBook4c = {1,2,3};
    	
    	try {
    		hotel1.updateBooking("Ref2",daysToBook4c , roomsToBook4c);						// Should be fine on booking reference "Ref2",and the selected days
		} catch (NoSuchBookingException e) {
			e.printStackTrace();
		}

    	System.out.println("\nTEST: updateBooking() 3\n");
    	// Should fail "Ref3"
    	try {
    		hotel1.updateBooking("Ref1", daysToBook4, roomsToBook4);						// Should fail on booking reference "Ref1"
		} catch (NoSuchBookingException e) {
			e.printStackTrace();
		}   
    }
}
