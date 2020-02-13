import location.Location;

public class Player {
	// SKRIV OM! /////////////////////////
	private Location position;
	private String name;
	public String currentXY;
	private Game game;
	/////////////////////////////////

	
	public Player(String name, Location startLocation, Game game) {
		this.position = startLocation;
		currentXY = "0,0";
		this.game = game;
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
			case "north": case "n":
			case "west": case "w":
			case "south": case "s":
			case "east": case "e":
				attemptToMove(currentXY, command);
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
	
	
	private void attemptToMove (String inputXY, String direction) {
		int x, y;
		int newx, newy;
		String new_XY_String;
		
		x = Location.getx_from_String(inputXY);
		y = Location.gety_from_String(inputXY);
		
		newx = x;
		newy = y;
		
		switch(direction) {
		case "north": case "n":
			newy = y + 1; // Y = Y + 1
			break;
		case "west": case "w":
			newx = x - 1; // X = X - 1
			break;
		case "south": case "s":
			newy = y - 1; // Y = Y - 1
			break;
		case "east": case "e":
			newx = x + 1; // X = X + 1
			break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			System.out.println("attemptToMove received an invalid direction");
		}
		
		
		new_XY_String = this.position.convert_xy_to_String(newx, newy);
		
		
		if( this.game.locationMap.containsKey(new_XY_String) ) {
			currentXY = newx + "," + newy;
			this.position = this.game.locationMap.get(new_XY_String);
			System.out.printf("You went %s.\n", direction);
		}else {
			System.out.println("That way is blocked.");
		}
		// System.out.println("attemptToMove_NORTH ran!");
	}
	
	
}