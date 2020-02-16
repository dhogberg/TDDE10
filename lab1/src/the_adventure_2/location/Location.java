package location;

public class Location {
	private String shortDesc;
	private String longDesc;
	private boolean visitedBefore = false;
	
	public Location(String shortDescription, String longDescription) {
		this.shortDesc = shortDescription;
		this.longDesc = longDescription;
	}
	

	
	// TEST // TEST // TEST // TEST // TEST // TEST //
	public boolean locationCommand(String command) {
		switch(command) {
			case "north": case "n":
				//attemptToMove(currentXY, command);
				System.out.println("Works!°!!#!#!");
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			System.out.println("NO WORKS NOT :( !°!!#!#!");
			return false;
				
		}
		return true;
	}
	// TEST // TEST // TEST // TEST // TEST // TEST //
	
	
	
	
	public void describeYourself() {
		
		if(!this.visitedBefore) {
			this.visitedBefore = true;
			System.out.print(this.longDesc);
		}else {
			System.out.print(this.shortDesc + ".");
		}
		
		// Print weather if we are outside
		if (this instanceof OutdoorsArea) {
			this.printWeather();
		}
		
	}
	
	public void printWeather() {
		// Function is defined inside OutdoorsArea class! 
	}
	
	public String convert_xy_to_String(int x, int y) {
		return x + "," + y;
	}
	
	public static int getx_from_String(String xy) {
		return Integer.valueOf( xy.substring( 0, xy.indexOf(",")) );
	}
	public static int gety_from_String(String xy) {
		return Integer.valueOf( xy.substring(xy.indexOf(",")+1, xy.length()) );
	}
	
}