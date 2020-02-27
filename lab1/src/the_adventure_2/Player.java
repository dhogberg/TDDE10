package the_adventure_2;

import java.util.ArrayList;

import location.*;
import items.*;


public class Player {
	// SKRIV OM! /////////////////////////
	private Location position;	
	private int appearance = 4;
	private Item item;
	private String name;
	public String currentXY;
	private Game game;
	private ArrayList<Item> playeritems = new ArrayList<Item>();
	private ArrayList<Item> wornitems = new ArrayList<Item>();
	private String playername;
	/////////////////////////////////

	public Player(Location startLocation, Game game) {
		this.position = startLocation;
		currentXY = "0,0";
		this.game = game;
		//this.playeritems.add(new Item());
		this.playeritems.add(new Bag("bag", 0.4));
	}
	
	public ArrayList<Item> playeritems() {
		return this.playeritems;
	}
	
	public void setPlayerName(String name) {
		this.playername = name;
		System.out.printf("You changed name to %s.\n", name);
	}

	// SKRIV OM! /////////////////////////
	public Location getLocation() {
		return this.position;
	}
	
	public void wearItem(Item item){
		wornitems.add(item);
		playeritems.remove(item);
	}
	
	public void takeoffItem() {
		playeritems.add(item);
		wornitems.remove(item);
	}
	
	public void giveItem(Item item) {
		playeritems.add(item);
		if(item.name == "batteries") {
			System.out.printf("You bought %s.\n", item.name);
		}else{
			System.out.printf("You picked up %s.\n", item.name);
		}
	};
	
	protected void changeLocation(Location newLocation) {
		this.position = newLocation;
	}
	
	
	//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
	//  //  //  //  //  //  //  //  //  //  //  //  //  //  C O M M A N D S //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
	//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
	private boolean playerCommand(String command) {
		switch(command) {
			case "help": case "h": case "?":
				displayAvailableCommands(currentXY);
				this.position.locationDirectionHelp(currentXY);
				this.position.locationItemHelp(currentXY);
				appearanceHelp();
				itemsHelp(currentXY);
				//System.out.print("\n");
				break;
			case "north": case "n":
			case "west": case "w":
			case "south": case "s":
			case "east": case "e":
				attemptToMove(currentXY, command);
				break;
			case "appearance": case "a":
				appearance();
				break;
			case "items": case "i":
				this.playeritems.get(0).itemSpecialCommand("items", this);
				break;
			//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				return false;
		}
		return true;
	}
	
	
	public void increaseAppearance(Integer x) {
		this.appearance = this.appearance + x;
	}
	public void decreaseAppearance(Integer x) {
		this.appearance = this.appearance - x;
	}
	public Integer getAppearance() {
		return this.appearance;
	}
	private void appearance() {
		System.out.println("Your appearance is: " + this.appearance);
	}
	private void appearanceHelp() {
		System.out.println("appearance/a - Displays your apperance");
	}
	
	
	public boolean try_itemCommands(String command){
		for (Item item: this.playeritems) {
			if(item.itemCommand(command, this)) {
				return true;
			}
		}
		return false;
	}
	
	public void itemsHelp(String currentXY){
		System.out.print("items/i - Displays your inventory\n");
		for (Item item: this.playeritems) {
			item.itemHelp(currentXY, this);
		}
	}

	
	
	public int doCommand(String command) {
		
		if(!playerCommand(command)) {
			if(!this.position.locationCommand(command)) {
				if(!try_itemCommands(command)) {
					System.out.println("Command not found, type 'help' or ? for available commands.");
				}
			}
		}
		return 1; // TRUE
		
	}
	//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
	//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
	//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
	
	
	private void displayAvailableCommands(String inputXY) {
		System.out.print(""
			+ "Available commands: \n"
			+ "help/h/? - Displays available commands \n"
		);
	}
	
	private void attemptToMove (String inputXY, String direction) {
		int x;
		int y;
		int newx;
		int newy;
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
			changeLocation(this.game.locationMap.get(new_XY_String));
			System.out.printf("You went %s.\n", direction);
			this.getLocation().describeYourself();
		}else {
			System.out.println("That way is blocked.\n");
		}
	}	
}