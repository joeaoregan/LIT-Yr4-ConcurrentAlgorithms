/*
    Hotel Room Booking System (Extended).
    
    Room.java
    
    Joe O'Regan
    K00203642
    
    11/01/2018
    
    A boolean array of rooms, is used to indicate if a room is booked
    or not using the day value entered as an index
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

	/*
	 * Return true if the room is booked for the day
	 * Or false if the room is not booked for the day specified
	 */
	public boolean GetBooked(int day) {
		return bookedForDay[day];							// Is the room booked for a given day
	}

	/*
	 * Mark a day as booked for the room
	 */
	public void SetBooked(int day) {
		bookedForDay[day] = true;							// Set a day as booked
	}

	/*
	 * Mark a day as not booked
	 */
	public void UnbookDay(int day) {
		bookedForDay[day] = false;							// Set a day as not booked
		System.out.println("Room->UnbookDay(): Day " + day + " unbooked");
	}
}
