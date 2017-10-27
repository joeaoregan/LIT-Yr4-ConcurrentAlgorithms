/*
    Hotel Room Booking System.
    
    Hotel.java
    
    Joe O'Regan
    K00203642
    
    26/10/2017
*/

import java.lang.reflect.Array;

public class Hotel {
	
	Room[] rooms;	// Array of rooms
	
	// Constructor
	// Constructs a hotel with room numbers as specified in roomNums
	public Hotel(int[] roomNums) {
		rooms = new Room[Array.getLength(roomNums)];
		
		for(int i = 0; i < Array.getLength(roomNums); i++ ) {
			rooms[i] = new Room(roomNums[i]);
			//System.out.println("Room number " + roomNums[i] + " added to hotel.");
			//System.out.println("Room number " + rooms[i].roomNum + " in hotel rooms array.");
		}
	}
	
	String showRooms() {
		String hotelRooms = "This hotel contains " + Array.getLength(rooms) + " room(s): ";

    	System.out.println("This hotel contains " + Array.getLength(rooms) + " room(s): ");
    	
		for (int i = 0; i < Array.getLength(rooms); i++) {
			hotelRooms += "\nRoom " + rooms[i].roomNum;
			System.out.println("Room " + rooms[i].roomNum);
		}
		
		return hotelRooms;
	}
		
	/* 
	 * returns true if the room roomNum is booked on any days
	 * specified in days, otherwise return false
	*/
	boolean roomBooked(int[] days, int roomNum) {
		boolean booked = false;
/*
		for (int i = 0; i < Array.getLength(days); i++) {
			for (int j = 0; j < Array.getLength(days); j++) {
				
				//if (days[i] == daysBooked[j])
				// Check the days wanted, against the days the room is already booked
					return true;
			}
		}		
		if (roomNum == days[i])
			return true; 
*/
		for (int j = 0; j < Array.getLength(rooms); j++) {
			if (rooms[j].roomNum == roomNum) {														// If the room number is in the hotel
				for (int i = 0; i < Array.getLength(days); i++) {									// For each day that needs to be booked
										
					if(rooms[j].isDayBooked(i)) {													// If the room is booked
						System.out.println("Room " + roomNum + " is booked on day " + i);
						booked = true;
					}
					else
						System.out.println("Room " + roomNum + " is available on day " + days[i]);	
				}
			}
		}	
		
		if(booked) System.out.println("The selected day(s) can not be booked."); 
		
		return booked;																				// booked = false = room available
	}
	
	boolean roomExistsInHotel(int roomNum) {
		boolean roomExists = false;
		
		// check valid room number
		for (int i = 0; i < Array.getLength(rooms); i++) {
			if (roomNum == rooms[i].roomNum) {	// If the room number entered matches a hotel room number
				roomExists = true;				// Valid room number for the hotel
				break;
			}
		}
		
		if (!roomExists) System.out.println("Sorry, room " + roomNum + " is not a valid room number");

		return roomExists;
	}
	
	/* Create a booking with reference bookingRef for the 
	 * room roomNum for each of the days specified in days
	 * Returns true if it is possible to book the room on the given days, 
	 * otherwise (if the room is booked on any of the specified days) return false.
	*/
	boolean bookRoom(String bookingRef, int[] days, int roomNum) {

		//if (!roomExistsInHotel(roomNum)) return false;											// Check the room actually exists first		
		//if (roomBooked(days, roomNum)) return false;
		if ((!roomExistsInHotel(roomNum)) || roomBooked(days, roomNum)) return false;				// If the room doesn't exist or, isn't available, not possible to book
		
/*		if(roomBooked(days, roomNum)) {
			System.out.println("The room " + roomNum + "has been booked for days ");
			for (int i = 0; i < Array.getLength(days); i++) {
				System.out.print(days[i]);
				if (i < Array.getLength(days) - 1) System.out.print(", ");
			}
			System.out.println("Your booking reference is:  " + bookingRef);			
			return true;
		}
		
		for (int j = 0; j < Array.getLength(rooms); j++) {
			if (rooms[j].roomNum == roomNum) {														// If the room number is in the hotel
				for (int i = 0; i < Array.getLength(days); i++) {									// For each day that needs to be booked
										
					if(rooms[j].isDayBooked(i))														// If the room is booked
						System.out.println("Room " + roomNum + " is booked on day " + i);	
					else
						System.out.println("Room " + roomNum + " is available on day " + days[i]);	
				}
			}
		}	
*/
		

		System.out.print("Room number " + roomNum + " has been booked for day(s): ");
		
		for (int i = 0; i < Array.getLength(days); i++) {
			System.out.print(days[i]);
			if (i < Array.getLength(days) - 1) System.out.print(", ");
			if (i == Array.getLength(days) - 1) System.out.print("\n");
		}
		
		System.out.println("Your booking reference is: " + bookingRef);
		
		return false;
	}
	
	/* Updates the booking with reference bookingRef so that it now refers to the specified roomNum for each of the days specified in days. 
	 * Returns true if it is possible to update the booking  (i.e., the new booking does not clash with an existing booking), 
	 * otherwise returns false and leaves the original booking unchanged. 
	 * If there is no booking with the specified reference throws NoSuchBookingException.
	 */
	boolean updateBooking(String bookingRef, int[] days, int roomNum) throws NoSuchBookingException {
		//if(NoSuchBookingException(bookingRef)) return false;
				
		return false;
	}
	
	// cancels the booking with reference bookingRef. The room booked under this booking reference becomes unbooked for the days of the booking. 
	// If there is no booking with the specified reference throws NoSuchBookingException
	void cancelBooking(String bookingRef) throws NoSuchBookingException {

	}
	
    public static void main(String [] args){
    	System.out.println("Concurrent Algorithms Assignment 1\nHotel Booking\n");

    	int[] hotel1Rooms = {1,2,3}; 
    	int[] hotel2Rooms = {2,4,6,8}; 

    	//System.out.println("Hotel 1:\n\n");
    	Hotel hotel1 = new Hotel(hotel1Rooms);
    	Hotel hotel2 = new Hotel(hotel2Rooms);    

    	//hotel1.showRooms();

    	//System.out.println("Hotel 1:\n\n");
    	
    	//hotel2.showRooms();   	
    	
    	//boolean bookRoom(String bookingRef, int[] days, int roomNum)
    	int[] daystobook = {1,2,4};
    	hotel1.bookRoom("Ref1", daystobook, 1);
    	hotel1.bookRoom("Ref1", daystobook, 4);	// Check for valid room number
    	

    	int[] daystobook2 = {3,4,5,6};
    	hotel2.bookRoom("Ref2", daystobook2, 2);
    }
}
