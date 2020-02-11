import location.Coords;
import location.Location;

public class Player {
	// SKRIV OM! /////////////////////////
	private Location position;
	private String name;
	/////////////////////////////////

	
	public Player(String name, Location startLocation) {
		this.position = startLocation;

	}

	// SKRIV OM! /////////////////////////
	public Location getLocation() {
		return this.position;
	}
	
	public void changeLocation(Location newLocation) {
		this.position = newLocation;
	}
	
	public int doCommand(String command) {
		switch(command) {
		
			case "north":
				System.out.println("You went NORTH");
				this.position = this.position.attemptToMove_NORTH(this.position);
				
				break;
			case "west":
				System.out.println("You went WEST");
				break;
			case "south":
				System.out.println("You went SOUTH");
				break;
			case "east":
				System.out.println("You went EAST");
				break;
				
			case "look":
				System.out.println("You wanted to run command LOOK, not implemented yet :)");
				break;
			//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				System.out.println("Command not found, type 'help' or ? for available commands.");
		}
		
		return 1;
	}
	
	//attemptToMove_NORTH(currentPlayerCords);
	
	
	private Location attemptToMove_NORTH (Location inputLocation) {
		inputLocation  = locations.get(1);
		
		// return locations.get(1);
	}
	
	
}