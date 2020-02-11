import java.util.*;
import location.*;
import java.util.HashMap;


public class Game {
    private Scanner keyboard; 
    private ArrayList<Location> locations;
    private Player player;
    
    HashMap<String, Location> locationMap = new HashMap<String, Location>();
    
    
    public Game() {
	    keyboard = new Scanner(System.in);
	    locations = new ArrayList<>();
	    
	    // must be added before locationMap is built! 
	    
	    buildLocations(); // Adds all locations to ArrayList "locations"
	    buildLocationMap(); // Builds locationMap, is dependent on currPos
	    
	   
	    // TEST // TEST // TEST // TEST // TEST // TEST // TEST //
	    // TEST // TEST // TEST // TEST // TEST // TEST // TEST //
	    
	    //System.out.println("X=" + Location.getx_from_String("-5,7") + ", Y=" + Location.gety_from_String("-5,7") + "");
	    
    }
    
    private void buildLocations() {
    	/* 0 */ locations.add(new OutdoorsArea("Stora Torget", " You wake up outdoor with an brutal headache and no memory of the night before. Confused you check your surroundings. To the left of you stands a large fountain. You quickly realize that you are at Stora Torget, Linköpings mighty square."));
    	/* 1 */ locations.add(new OutdoorsArea("Outside Platens", "Long text outside Platens"));
    	/* 2 */ locations.add(new OutdoorsArea("Trädgårdstorget", "Long text Trädgårdstorget"));
    	/* 3 */ locations.add(new Room("Galleria Filbyter floor 1", "Long text Galleria Filbyter floor 1"));
    	/* 4 */ locations.add(new Room("Galleria Filbyter floor -1", "Long text Galleria Filbyter floor -1"));
    	/* 5 */ locations.add(new Room("Hemköp Lucullus", " Long text Hemköp Lucullus"));
    	/* 6 */ locations.add(new Room("Platens Bar", "Long text Platens Bar"));
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
    	String name; // = "Davveboi & Kämpe"; // Holds player name
        System.out.println("Welcome to the adventure 2!\nWhat is your name?");
        name = keyboard.nextLine(); // Takes in name from player
        
        player = new Player(name, locations.get(0), this);
        System.out.println("Hello " + name + ", welcome to this magical world of wonder! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");
	
		while (true) {
	            String command;
		    player.getLocation().describeYourself();
		    System.out.println("What do you want to do?");
		    command = keyboard.nextLine();
		    player.doCommand(command); // Returns an int=1 normally, but can be used to end game, etc...
		}
    }
}