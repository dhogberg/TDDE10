package location;

import the_adventure_2.Player;

public class Room extends Location {
	
	public Room(String shortDescription, String longDescription, Player player) {
		// Kolla upp vad super betyder! Skriv eventuellt om VVVV
		super(shortDescription, longDescription, player);
	}
	
	@Override
	public void displayAvailablePaths(){
		System.out.println("You are in a room, there is a door leading bla bla bla");
	}

}