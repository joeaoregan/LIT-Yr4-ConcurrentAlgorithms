/*
    Hotel Room Booking System.
    
    Room.java
    
    Joe O'Regan
    K00203642
    
    26/10/2017
*/

public class Room {
	public int roomNum;
	boolean booked;
	
	boolean[] bookedForDay = new boolean[30];	// 30 days - array position = day number, true for booked, false for available
	
	// constructor
	public Room(int roomNumber) {
		roomNum = roomNumber;
		//int[] daysBooked;
		booked = false;
	}	
	
	public boolean isDayBooked(int day) {
		return bookedForDay[day];				// Is the room booked for a given day
	}
}
