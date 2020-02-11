package location;

import java.util.ArrayList;

import jdk.javadoc.internal.doclets.toolkit.taglets.ReturnTaglet;

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
			System.out.println("println(this.longDesc): " + this.longDesc);
			
		}else {
			System.out.println("println(this.shortDesc): " + this.shortDesc);
		}
	}
	//////////////////////////////////////

	/*
	public ArrayList<Location> getLocations() {
		return this.locations;
	}
	*/
	
	
}