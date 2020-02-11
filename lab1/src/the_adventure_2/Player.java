import location.Location;

public class Player {
	// SKRIV OM! /////////////////////////
	private Location position;
	private String name;
	public String currentXY;
	/////////////////////////////////

	
	public Player(String name, Location startLocation) {
		this.position = startLocation;
		currentXY = "0,0";

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
				this.position = attemptToMove_NORTH();
				
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
	
	//attemptToMove_NORTH(currentPlayerXY);
	
	
	private Location attemptToMove_NORTH (String inputXY) {
		private int x;
		private int y;
		
		System.out.println(this.position.convert_xy_to_String(2,7));
		// System.out.println("attemptToMove_NORTH ran!");
		
		// return locationMap.get(inputLocation);
	}
	
	
}