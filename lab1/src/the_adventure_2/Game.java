package the_adventure_2;

import java.util.*;
import location.*;
import items.*;
import java.util.HashMap;


public class Game {
    private Scanner keyboard; 
    private ArrayList<Location> locations;
    public Player player;
    HashMap<String, Location> locationMap = new HashMap<String, Location>();
    
    public Game() {
    	keyboard = new Scanner(System.in);
	    locations = new ArrayList<>();
	    buildLocations(); // Adds all locations to ArrayList "locations"
	    addItemsToLocations(); // Adds items to locations 
	    buildLocationMap(); // Builds locationMap, is dependent on currPos
	    player = new Player(locations.get(0), this);
	    addPlayerToLocations(player);
    }
    
    private void addPlayerToLocations(Player player) {
    	for(Location location: locations) {
    		location.setPlayer(player);
    	}
    }
    
    private void buildLocations() {
    	/* 0 */ locations.add(new OutdoorsArea("Stora Torget", "You wake up outdoor with an brutal headache and no memory of the night before. Confused you check your surroundings. To the left of you stands a large fountain. You quickly realize that you are at Stora Torget, Linköpings mighty square."));
    	/* 1 */ locations.add(new OutdoorsArea("Outside Platens", "Long text outside Platens"));
    	/* 2 */ locations.add(new OutdoorsArea("Trädgårdstorget", "Long text Trädgårdstorget"));
    	/* 3 */ locations.add(new Room("Galleria Filbyter floor 1", "Long text Galleria Filbyter floor 1"));
    	/* 4 */ locations.add(new Room("Galleria Filbyter floor -1", "Long text Galleria Filbyter floor -1"));
    	/* 5 */ locations.add(new Room("Hemköp Lucullus", "Long text Hemköp Lucullus"));
    	/* 6 */ locations.add(new Room("Platens Bar", "Long text Platens Bar"));
    	/* 7 */ locations.add(new DarkRoom("Closed H&M", "Closed H&M store, currently under construction. It is very dark, there are no lights turned on."));
    }
    
    private void addItemsToLocations() {
    	locations.get(2).addItem(new Flashlight("flashlight", 0.6));
    	locations.get(3).addItem(new Hat("hat", 0.35));
    	locations.get(5).addItem(new Batteries("batteries", 0.15));
    	locations.get(7).addItem(new Jacket("jacket", 0.4));
    }
    
    private void buildLocationMap() {
    	locationMap.put( ( "0" + "," +  "0") , locations.get(0));
    	locationMap.put( ( "0" + "," +  "1") , locations.get(1));
    	locationMap.put( ( "0" + "," + "-1") , locations.get(2));
    	locationMap.put( ("-1" + "," +  "0") , locations.get(3));
    	locationMap.put( ("-2" + "," +  "0") , locations.get(4));
    	locationMap.put( ("-2" + "," +  "1") , locations.get(5));
    	locationMap.put( ( "1" + "," +  "1") , locations.get(6));
    	locationMap.put( ("-2" + "," +  "-1") , locations.get(7));
    }

    public void run() {
    	String name;
        System.out.println("Welcome to the adventure 2!\nWhat is your name?");
        name = keyboard.nextLine(); // Takes in name from player
        player.setPlayerName(name);
        System.out.println("Hello " + name + ", welcome to this magical world of wonder! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").\n");
        player.getLocation().describeYourself();
        
		while (true) {
	        String command;
		    System.out.println("\nWhat do you want to do?");
		    command = keyboard.nextLine();
		    System.out.print("\n");
		    player.doCommand(command); // Returns an int=1 normally, but can be used to end game, etc...
		}
    }
}