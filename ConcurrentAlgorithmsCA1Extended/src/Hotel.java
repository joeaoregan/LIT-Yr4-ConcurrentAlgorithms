/*
    Hotel Room Booking System (Extended).
    
    Hotel.java
    
    Joe O'Regan
    K00203642
    
    11/01/2018
    
    The following functions have been changed to take an array of room numbers
    as an argument, or handle an array of room numbers:
    
    roomBooked() changed to roomsBooked()
    bookRoom() changed to bookRooms()
    updateBooking()
    cancelBooking()
*/

import java.lang.reflect.Array;
import java.util.*;

/*
  	Construct a hotel with room numbers as specified in roomNums. 
  	The rooms are initially unbooked. 
*/
public class Hotel {
	
	//Lec8 S43 public static Map SynchronizedMap<String,Booking>();
	Map<String,Booking> map = new HashMap<String,Booking>();											// Create a map
	Map<String,Booking> bookingList = Collections.synchronizedMap(map);									// Create a synchronised map of bookings (Tutorialspoint)
	
	public Room[] rooms;	// Array of rooms

	/*
	 *  Check the booking reference exists
	 */
	public boolean checkBookingOnList(String ref) {
		//synchronized(bookingList) {																	// Lock access to the synchronized map
			return bookingList.containsKey(ref);
		//}
	}
			
	/* 	
	 	Constructs a hotel with room numbers as specified in roomNums
	*/
	public Hotel(int[] roomNums) {
		rooms = new Room[Array.getLength(roomNums)];													// Create rooms list for the hotel
		
		for(int i = 0; i < Array.getLength(roomNums); i++ ) {
			rooms[i] = new Room(roomNums[i]);															// Add each room to the hotels array of Rooms
		}
	}

	/*
	 * Takes a name string parameter to identify the hotel, 
	 * and displays the room numbers contained in the hotel.
	 */
	void showRooms(String name) {
		int i;
		String hotelRooms = "Hotel "+name+" contains " + Array.getLength(rooms) + " room(s) numbered: ";
    	
		for (i = 0; i < Array.getLength(rooms) - 1; i++) {
			hotelRooms += rooms[i].roomNum + ", ";
			//System.out.println("Room " + rooms[i].roomNum);
		}
		hotelRooms += rooms[i].roomNum;
		System.out.println(hotelRooms);
	}
		
	/* 
	 * returns true if the room roomNum is booked on any days
	 * specified in days, otherwise return false
	 * In this extended version it takes an integer array of 
	 * room numbers 
	 */
	public boolean roomsBooked(int[] days, int[] roomNums) {
		System.out.println("FUNCTION: roomsBooked():");
		boolean booked = false;
		String unavailableDays = "";
		//int count =0;		
		
   		for (int l = 0; l < Array.getLength(roomNums); l++) {												// Booking day
    		String availableDays = "";																		// Clear the string
       		//unavailableDays = "";																			// Clear the string 
   			//System.out.println("Count " + ++count);   			
       		//System.out.println("Room: " + roomNums[l]);    		
    		
   			//for (int j = 0; j < 30; j++) {																// Day
   				//System.out.println("days" + j);
   			for (int k = 0; k < Array.getLength(days); k++)	 {
   	   				//System.out.println("days" + k);			
   	       		//System.out.println("Room: " + roomNums[l]);  
   				for (int i = 0; i < Array.getLength(rooms); i++) {											// Room 	   					
   		       		//System.out.println("Room: " + roomNums[l]);  
   			   		for (int j = 0; j < 30; j++) {		   						
		    			if (rooms[i].roomNum == roomNums[l] && rooms[i].GetBooked(j) ) {					// If booked on this day already				
		   		       		//System.out.println("Room: " + roomNums[l]);  
		    				if (j == days[k]) {
		    					//System.out.println("roomBooked(): Room " + rooms[i].roomNum + " is booked already on day " + j);
		    					if (unavailableDays == "") unavailableDays += "Room " + roomNums[l] + " Day " + j;			// Don't add comma if empty
		    					else unavailableDays += ", " + j;											// Otherwise do add comma
		    				}
		    				
		    				booked = true;
		    			}
		    			else if (rooms[i].roomNum == roomNums[l] && j == days[k]) {				
		   		       		//System.out.println("Room: " + roomNums[l]);  
		    				//System.out.println("roomBooked(): Room " + rooms[i].roomNum + " is available on day " + j);
		    				if (availableDays == "") availableDays += j;
		    				else availableDays += ", " + j;
		    			}
   					}
				}
   			}
   			//if (availableDays != "") System.out.println("Test");
   			if (availableDays != "") System.out.println("roomsBooked(): Room "+roomNums[l]+" is available on days: " + availableDays);
   			//if (availableDays != "") System.out.println("Count " + count + " Room "+roomNums[l]+" is available on days: " + availableDays);
   						
   		} // for roomNums	

		if (booked && unavailableDays != "") {
			//System.out.println("roomsBooked(): The following day(s) cannot be booked: " + unavailableDays + "\n"); 
			System.out.println("roomsBooked(): The following day(s) cannot be booked: " + unavailableDays); 
			//return true;
			booked = true;
		}       
		
    	if (unavailableDays == "") booked = false;
    	
		return booked;																						// booked = false = room available
	}
		
	// Check the room has been set up for the hotel
	boolean roomExistsInHotel(int[] roomNums) {
		boolean roomExists = false;																			// Initially the room exists before checking the array
		//boolean roomExists =  true;																		// Initially the room exists before checking the array
		String invalidRooms = "";
		int count = 0;
		
		for (int i = 0; i < Array.getLength(roomNums); i++) {												// For every room number entered	
			roomExists = false;																				// Reset room existing for each room to be checked
			
			for (int j = 0; j < Array.getLength(rooms); j++) {												// check valid room number
				if (roomNums[i] == rooms[j].roomNum) {														// If the room number entered matches a hotel room number
					roomExists = true;																		// Valid room number for the hotel
					break;
				} 
			}	
			
			if (!roomExists) {
				if (count == 0) invalidRooms += " " + roomNums[i];
				else invalidRooms += ", " + roomNums[i];
				count++;
			}
		}

		//if (!roomExists) System.out.println("Sorry, room " + roomNums[i] + " is not a valid room number");
		if (!roomExists && count == 1) System.out.println("Sorry, room" + invalidRooms + " is not a valid room number");
		if (!roomExists && count > 1) System.out.println("Sorry, rooms" + invalidRooms + " are not valid room numbers");
		
		return roomExists;
	}
		
	/* Create a booking with reference bookingRef for the 
	 * room roomNum for each of the days specified in days
	 * Returns true if it is possible to book the room on the given days, 
	 * otherwise (if the room is booked on any of the specified days) return false.
	*/
//	public synchronized boolean bookRooms(String bookingRef, int[] days, int[] roomNums) {					// Using synchronized hash map
	public boolean bookRooms(String bookingRef, int[] days, int[] roomNums) {
		// Check the booking reference number is not already used
		if(checkBookingOnList(bookingRef)) {
			System.out.println("Booking Ref: " + bookingRef + " is already in our system\nPlease try another reference number for your records");
			return false;
		}
		// 	Check room number exists
		//for (int i=0; i < Array.getLength(roomNums); i++) {
		if ((!roomExistsInHotel(roomNums)) || roomsBooked(days, roomNums)) {								// If the room doesn't exist or, isn't available, not possible to book
			System.out.println("Your booking " + bookingRef + " could not be created");						// Acknowledge booking
			return false;																					// not possible to book
		}
		
		// Mark the days as booked
		for (int i=0; i<Array.getLength(roomNums);i++) {
			for (int j = 0; j < Array.getLength(rooms); j++) {
				if (rooms[j].roomNum == roomNums[i]) {														// Find the room in the hotels list of rooms
					for (int k = 0; k < Array.getLength(days); k++) {										// For each day that needs to be booked										
						rooms[j].SetBooked(days[k]);														// Set the room as booked
					}
				}
			}
		}			
		
		for (int i=0;i<Array.getLength(roomNums);i++) {
			// Show the room numbers booked
			System.out.print("bookRoom(): Room " + roomNums[i] + " has been booked for day(s): ");			
			for (int j = 0; j < Array.getLength(days); j++) {
				System.out.print(days[j]);
				if (j < Array.getLength(days) - 1) System.out.print(", ");
				if (j == Array.getLength(days) - 1) System.out.print("\n");
			}			
		}

		// Create the booking
		//Booking newBooking = new Booking(bookingRef,days,roomNums[i]);									// Create a booking
		Booking newBooking = new Booking(bookingRef,days,roomNums);											// Create a booking
		//synchronized(bookingList) {																		// Lock access to the synchronized map
			bookingList.put(bookingRef, newBooking);														// Add the booking to the synchronised map
		//}
		System.out.println("\nbookRooms() call Booking toString():\n" + newBooking);						// Use toString() to show details for booking
		System.out.println("Your booking " + bookingRef + " has been created");								// Acknowledge booking
					
		return true;
	}
	
	/* Updates the booking with reference bookingRef so that it now 
	 * refers to the specified roomNum for each of the days specified in days. 
	 * Returns true if it is possible to update the booking  (i.e., 
	 * the new booking does not clash with an existing booking), 
	 * otherwise returns false and leaves the original booking unchanged. 
	 * If there is no booking with the specified reference throws NoSuchBookingException.
	 */
	boolean updateBooking(String bookingRef, int[] days, int[] roomNums) throws NoSuchBookingException {
		//if booking doesn't exist throw NoSuchBookingException(bookingRef);
		if(!checkBookingOnList(bookingRef))
			throw new NoSuchBookingException(bookingRef);
		
		boolean update = true;
		
		/*
		System.out.print("updateBooking() - Update Booking Ref: " + bookingRef + ", Days: ");
		// Show the days to check
		for (int i = 0; i < Array.getLength(days); i++) {
			System.out.print(days[i] + ", ");
		}
		System.out.println("Room Num: " + roomNum);
		*/
		for (int k = 0; k < Array.getLength(roomNums);k++) {
			if(roomsBooked(days, roomNums)) {		
				
				System.out.println("updateBooking(): Room is booked");
				
				int[] checkDays = bookingList.get(bookingRef).days;
				int checkRoom = bookingList.get(bookingRef).roomNums[k];
				
				if (roomNums[k] == checkRoom) {
					System.out.println("Room Num: " + roomNums[k] + " matches room to update");	// if the booking that clashes is the same booking ref
					
					for (int i = 0; i <Array.getLength(days); i++) {
						for (int j = 0; j < Array.getLength(checkDays); j++) {
							if(days[i] == checkDays[j]) {
								System.out.println("This booking clashes with itself");
								System.out.println("Day: " + days[i] + " matches day to update");
							}
						}
					}
				}
				
				System.out.println("updateBooking(): Please try another selection.");
				
				//return false;				
				update =  false;
			} 
		}
		
		//else {
		// If it is OK to update cancel the previous booking, and re-book with new days and rooms
		if (update) {
			System.out.println("The room was not booked for the given days");
			
			cancelBooking(bookingRef);				// cancel the booking
			bookRooms(bookingRef, days, roomNums);	// Re-book with new days		
		}
		
		//return true;
		return update;
	}
		
	/* cancels the booking with reference bookingRef. The room booked under this 
	 * booking reference becomes unbooked for the days of the booking. 
	 * If there is no booking with the specified reference throws NoSuchBookingException
	*/
	void cancelBooking(String bookingRef) throws NoSuchBookingException {		
		if(!checkBookingOnList(bookingRef))
			throw new NoSuchBookingException(bookingRef);
		else {
			//System.out.println("Implement cancelling this booking");	// test
			//int[] day = bookingList.get(bookingRef).days;
			//int room = bookingList.get(bookingRef).roomNum;

			//System.out.println("Room: " + bookingList.get(bookingRef).roomNum + ": ");
			
			for (int i = 0; i < Array.getLength(bookingList.get(bookingRef).days); i++) {							// days
				//rooms[room].UnbookDay(day[i]);
				//System.out.println("Room: " + bookingList.get(bookingRef).roomNum + ": ");
				//rooms[bookingList.get(bookingRef).roomNum].UnbookDay(bookingList.get(bookingRef).days[i]);
				//synchronized(bookingList) {																			// Lock access to the synchronized map
					System.out.println("Cancelling day: " + bookingList.get(bookingRef).days[i]);
				//}
				//rooms[j].SetBooked(days[i]);
				for (int j = 0; j < Array.getLength(rooms); j++) {													// rooms
					//synchronized(bookingList) {																		// Lock access to the synchronized map
						for (int k = 0; k < Array.getLength(bookingList.get(bookingRef).roomNums); k++) {
							if (rooms[j].roomNum == bookingList.get(bookingRef).roomNums[k]) {						// Find the room in the hotels list of rooms
								System.out.println("Room to unbook: " + rooms[j].roomNum);
					
								//for (int k = 0; k < Array.getLength(bookingList.get(bookingRef).days); k++) {		// For each day that needs to be booked										
									rooms[j].UnbookDay(bookingList.get(bookingRef).days[i]);						// Set the room as booked
									//if(rooms[j].GetBooked(days[i])) System.out.println("bookRoom(): Room " + rooms[j].roomNum + " has been booked for day " + days[i]);
								//}
							}
						}
					//}
				}			
			}

			//synchronized(bookingList) {																			// Lock access to the synchronized map
				bookingList.remove(bookingRef);
			//}
			
			System.out.println("Booking ref: " +bookingRef+" removed from system");
		}
		
		/*
		try {
			if(!checkBookingOnList(bookingRef))
				throw new NoSuchBookingException(bookingRef);
		} catch (NoSuchBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("NoSuchBookingException works\n");
		}
		*/
	}
	
	void displayAllRoomBookings(String name) {
		String booked = "";
    	System.out.println("Hotel " + name + " All Bookings:");
    	
    	for (int i = 0; i < Array.getLength(rooms); i++) {					// Check the room
    		booked = "";													// Reset for each room
    		for (int j = 0; j < 30; j++)									// Check the day
    			if (rooms[i].GetBooked(j))  {
    				//System.out.println("Main: Room " + rooms[i].roomNum + " is booked on day " + j);  
    				if (booked == "") booked += j;
    				else booked += ", " + j;
    			} 
    		
	    	if (booked != "") System.out.println("Days(s) " + booked + " are booked for room " + rooms[i].roomNum);
    	}
    	
    	if (booked == "") System.out.println("No bookings");
	}	
}
