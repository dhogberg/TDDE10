package the_adventure_2;

import java.util.*;
import location.*;
import items.*;
import java.util.HashMap;


public class Game {
    private Scanner keyboard; 
    private ArrayList<Location> locations;
    private Player player;
    public int weatherCount;
    HashMap<String, Location> locationMap = new HashMap<String, Location>();
    
    public Game() {
	    keyboard = new Scanner(System.in);
	    locations = new ArrayList<>();
	    buildLocations(); // Adds all locations to ArrayList "locations"
	    addItemsToLocations(); // Adds items to locations 
	    buildLocationMap(); // Builds locationMap, is dependent on currPos
	    weatherCount = 0;
    }
    
    public int getWeatherCount() {
    	return this.weatherCount;
    }
    
    private void buildLocations() {
    	/* 0 */ locations.add(new OutdoorsArea("Stora Torget", "You wake up outdoor with an brutal headache and no memory of the night before. Confused you check your surroundings. To the left of you stands a large fountain. You quickly realize that you are at Stora Torget, Linköpings mighty square.", this.player));
    	/* 1 */ locations.add(new OutdoorsArea("Outside Platens", "Long text outside Platens", this.player));
    	/* 2 */ locations.add(new OutdoorsArea("Trädgårdstorget", "Long text Trädgårdstorget", this.player));
    	/* 3 */ locations.add(new Room("Galleria Filbyter floor 1", "Long text Galleria Filbyter floor 1", this.player));
    	/* 4 */ locations.add(new Room("Galleria Filbyter floor -1", "Long text Galleria Filbyter floor -1", this.player));
    	/* 5 */ locations.add(new Room("Hemköp Lucullus", " Long text Hemköp Lucullus", this.player));
    	/* 6 */ locations.add(new Room("Platens Bar", "Long text Platens Bar", this.player));
    }
    
    private void addItemsToLocations() {
    	//locations.get(0).addItem
    	//locations.get(1).addItem();
    	//locations.get(2).addItem();
    	locations.get(3).addItem(new Flashlight(this.player));
    	//locations.get(4).addItem();
    	//locations.get(5).addItem();
    	//locations.get(6).addItem();
    }
    
    private void buildLocationMap() {
    	locationMap.put( ( "0" + "," +  "0") , locations.get(0));
    	locationMap.put( ( "0" + "," +  "1") , locations.get(1));
    	locationMap.put( ( "0" + "," + "-1") , locations.get(2));
    	locationMap.put( ("-1" + "," +  "0") , locations.get(3));
    	locationMap.put( ("-2" + "," +  "0") , locations.get(4));
    	locationMap.put( ("-2" + "," +  "1") , locations.get(5));
    	locationMap.put( ( "1" + "," +  "1") , locations.get(6));
    }

    public void run() {
    	String name = "Davveboi & Kämpe"; // Holds player name
        // System.out.println("Welcome to the adventure 2!\nWhat is your name?");
        // name = keyboard.nextLine(); // Takes in name from player
        player = new Player(name, locations.get(0), this);
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