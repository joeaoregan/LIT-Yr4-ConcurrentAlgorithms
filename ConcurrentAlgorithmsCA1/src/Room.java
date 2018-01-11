/*
    Hotel Room Booking System.
    
    Room.java
    
    Joe O'Regan
    K00203642
    
    26/10/2017
*/

//import java.util.Vector;

public class Room {
	public int roomNum;
	//boolean booked;
	
	// Create a boolean array, with index indicating the day number
	// If the room is booked on a day, set corresponding index to true
	// Otherwise leave false
	boolean[] bookedForDay = new boolean[30];				// 30 days - array position = day number, true for booked, false for available
	//Vector<Integer> bookedForDays = new Vector<Integer>();// List of days the room is booked for	
	
	// constructor
	public Room(int roomNumber) {
		roomNum = roomNumber;
		//int[] daysBooked;
		//booked = false;
	}	
	
	public boolean GetBooked(int day) {
		return bookedForDay[day];							// Is the room booked for a given day
	}
	
	public void SetBooked(int day) {
		bookedForDay[day] = true;							// Set a day as booked
	}
	
	public void UnbookDay(int day) {
		bookedForDay[day] = false;							// Set a day as not booked
		System.out.println("Room->UnbookDay(): Day " + day + " unbooked");
	}
}
