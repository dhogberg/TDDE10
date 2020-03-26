package location;

import java.util.ArrayList;
import the_adventure_2.Player;
import items.*;

public abstract class Location {
	private String shortDesc;
	private String longDesc;
	private boolean visitedBefore = false;
	private ArrayList<Item> items_on_location = new ArrayList<Item>();
	private Player player;

	public Location(String shortDescription, String longDescription) {
		this.shortDesc = shortDescription;
		this.longDesc = longDescription;
	}

	public String shortDescription(){
		return this.shortDesc;
	}

	public String get_typeOfPath(){
		return "road";
	}
	public String get_typeOfGround(){
		return "ground";
	}

	public ArrayList<Item> get_items_on_location(){
		return this.items_on_location;
	}
	
	
  //TODO: Komplettering: Detta är lite som att säga är klassen av
  //type DarkRoom eller är den inte det. Då tappar man lite
  //av objektorienteringen. Låt istället DarkRoom ansvara över vad
  //som sker när man försöker ta något från DarkRoom. 
	
	/*public Boolean RoomIsDark(){
		// Override in subclass DarkRoom
		return false;
	}*/
	
	/*public void lightenRoom(){

	}*/

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
				System.out.printf("buy %s - Buy %s\n", item.getName(), item.getName());
			}
		}else {
			for(Item item: player.getLocation().items_on_location) {
				System.out.printf("take %s - Pick up %s\n", item.getName(), item.getName());
			}
		}
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void addItem(Item item) {
		this.items_on_location.add(item);
	}

	/*
	public void lookOnLocation(Player player){
		// Override in subclasses
	}*/

	public abstract void lookOnLocation(Player player);

  //TODO[FIXAD]: Komplettering: Låt OutdoorsArea respektive Room ansvara över vilken typ av Location
  //det är och alltså vilken typ av path det är. 
	//---- FIXAT ----
	//---- FIXAT ----
	public void displayAvailablePaths(Player player/*, String typeOfLocation*/){

		String typeOfPath;

		/*
		switch(typeOfLocation) {
			case "OutdoorsArea":
				typeOfPath = "road";
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				typeOfPath = "door";
		}*/

		typeOfPath = player.getLocation().get_typeOfPath();
		

		Boolean northPossible = false;
		Boolean westPossible = false;
		Boolean southPossible = false;
		Boolean eastPossible = false;
		
		String northMoveCoords;
		String westMoveCoords;
		String southMoveCoords;
		String eastMoveCoords;
		
		//int x = Location.getx_from_String(player.currentXY);
		//int y = Location.gety_from_String(player.currentXY);
		int x = Location.getx_from_String(player.get_currentXY());
		int y = Location.gety_from_String(player.get_currentXY());

		northMoveCoords = player.getLocation().convert_xy_to_String(x, y + 1);
		westMoveCoords  = player.getLocation().convert_xy_to_String(x - 1, y);
		southMoveCoords = player.getLocation().convert_xy_to_String(x, y - 1);
		eastMoveCoords  = player.getLocation().convert_xy_to_String(x + 1, y);
			
		if(player.getGame().getLocationMap().containsKey(northMoveCoords)) {
			northPossible = true;
		}
		if(player.getGame().getLocationMap().containsKey(westMoveCoords)) {
			westPossible = true;
		}
		if(player.getGame().getLocationMap().containsKey(southMoveCoords)) {
			southPossible = true;
		}
		if(player.getGame().getLocationMap().containsKey(eastMoveCoords)) {
			eastPossible = true;
		}
		
		if(northPossible) {
			System.out.printf("There is a %s leading north.\n", typeOfPath);
		}
		if(westPossible) {
			System.out.printf("There is a %s leading west.\n", typeOfPath);
		}
		if(southPossible) {
			System.out.printf("There is a %s leading south.\n", typeOfPath);
		}
		if(eastPossible) {
			System.out.printf("There is a %s leading east.\n", typeOfPath);
		}
	}

  //TODO[FIXAD]: Komplettering: Samma som RoomIsDark(). Hör den verkligen till Location?
	//---- FIXAT ----
	//---- FIXAT ----

	/* public void display_items_darkroom(){
		// Override in subclasses
	}*/
	
	/*public void display_items(String typeOfLocation){*/
	public void display_items(){
		String typeOfGround;

		typeOfGround = player.getLocation().get_typeOfGround();

		/*
		switch(typeOfLocation) {
			case "OutdoorsArea":
				typeOfGround = "ground";
				break;
			case "Store":
				typeOfGround = "shelves";
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				typeOfGround = "floor";
		}*/
		
		for(Item item: player.getLocation().items_on_location) {
			System.out.printf("There is a %s laying on the %s.\n", item.getName(), typeOfGround);
		}
	}
	
	public boolean locationCommand(String command, Player player) {
		
		if (command.length() > 3) {
			if(command.startsWith("buy")) {
				for (Item item: player.getLocation().items_on_location) {
					if(command.substring(4).equals(item.getName())) {
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
					if(command.substring(5).equals(item.getName())) {
                                          //TODO: Komplettering: Om ni tar bort metoden RoomIsDark()
                                          //kan ni då istället låta DarkRoom själv ha ansvaret över 
                                          //att det inte går att ta upp något där. Så att ni 
                                          //här anropar en metod förslagvis take() som DarkRoom
                                          //överskuggar. 
						if(take(player, item)) {
							return true;
						}else{
							return false;
						}
						/*if(!RoomIsDark()) {
							player.giveItem(item);
							player.getLocation().items_on_location.remove(item);
							return true;
						}else {
							return false;
						}*/
					}
				}
			}
		}
		
		switch(command) {
			case "look": case "l":
				System.out.print("You are at "); this.describeYourself();
				lookOnLocation(player); // @Override in subclasses
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				return false;
		}
		return true;
	}
	
	public Boolean take(Player player, Item item) {
		player.giveItem(item);
		player.getLocation().items_on_location.remove(item);
		return true;
	}
	
	public void describeYourself() {
		if(!this.visitedBefore) {
			this.visitedBefore = true;
			System.out.print(this.longDesc);
		}else {
			System.out.print(this.shortDesc + ".");
		}
		//this.printWeather();
		System.out.print("\n");
	}
	
	/*public void printWeather() {
		// @Override in subclass OutdoorsArea 
	}*/
	
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
