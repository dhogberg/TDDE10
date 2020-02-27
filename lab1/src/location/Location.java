package location;

import java.util.ArrayList;

import the_adventure_2.Player;

import items.*;
import location.OutdoorsArea;
import location.Room;
import the_adventure_2.Game;

public class Location {
	private String shortDesc;
	private String longDesc;
	private boolean visitedBefore = false;
	private ArrayList<Item> items_on_location = new ArrayList<Item>();
	public Player player;
	
	public Location(String shortDescription, String longDescription) {
		this.shortDesc = shortDescription;
		this.longDesc = longDescription;
	}
	
	public void lightenRoom(){
	}

	public void locationDirectionHelp(String currentXY) {
		System.out.print(""
				+ "look/l - Shows where you can go \n"
				+ "north/n - Go north \n"
				+ "west/w - Go west \n"
				+ "south/s - Go south \n"
				+ "east/e - Go east \n"
		);
	}
	
	public void locationItemHelp(String currentXY) {
		if(shortDesc.contains("Hemköp")) {
			for(Item item: player.getLocation().items_on_location) {
				System.out.printf("buy %s - Buy %s\n", item.name, item.name);
			}
		}else {
			for(Item item: player.getLocation().items_on_location) {
				System.out.printf("take %s - Pick up %s\n", item.name, item.name);
			}
		}
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void addItem(Item item) {
		this.items_on_location.add(item);
	}
	
	public void displayAvailablePaths(){
		System.out.println("Default, should never run!"); // TA BORT INNAN REDOVISNING
	}
	
	public void display_items(){
		for(Item item: player.getLocation().items_on_location) {
			System.out.printf("There is a %s laying on the ground.\n", item.name);
		}
	}
	
	
	public boolean locationCommand(String command) {
		
		if (command.length() > 3) {
			if(command.startsWith("buy")) {
				for (Item item: player.getLocation().items_on_location) {
					if(command.substring(4).equals(item.name)) {
						player.giveItem(item);
						player.getLocation().items_on_location.remove(item);
						return true;
					}
				}
			}
		}
		
		if (command.length() > 4) {
			if(command.startsWith("take")) {
				for (Item item: player.getLocation().items_on_location) {
					if(command.substring(5).equals(item.name)) {
						player.giveItem(item);
						player.getLocation().items_on_location.remove(item);
						return true;
					}
				}
			}
		}
		
		switch(command) {
			case "look": case "l":
				displayAvailablePaths(); // Show available paths - @Override in Room.java and OutdoorsArea.java
				display_items();
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			return false;
				
		}
		return true;
	}
	
	
	public void describeYourself() {
		
		if(!this.visitedBefore) {
			this.visitedBefore = true;
			System.out.print(this.longDesc);
		}else {
			System.out.print(this.shortDesc + ".");
		}
		this.printWeather();
		System.out.print("\n");
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