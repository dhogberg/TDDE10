package location;

//import java.util.ArrayList;

// import jdk.javadoc.internal.doclets.toolkit.taglets.ReturnTaglet;

public class Location {
	private String shortDesc;
	private String longDesc;
	private boolean visitedBefore = false;
	
	public Location(String shortDescription, String longDescription) {
		this.shortDesc = shortDescription;
		this.longDesc = longDescription;
	}
	
	// SKRIV OM! /////////////////////////
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
	//////////////////////////////////////
	
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
    
    //String kept = str.substring( 0, str.indexOf(","));
    //String remainder = str.substring(str.indexOf(",")+1, str.length());
	
	
	
	/*
	public ArrayList<Location> getLocations() {
		return this.locations;
	}
	*/
	
	
}