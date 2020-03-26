package location;

import the_adventure_2.Player;

public class Room extends Location {
	
	public Room(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}
	
	@Override
	public void lookOnLocation(Player player){
		this.displayAvailablePaths(player, "Room");
		
		if(this.shortDescription().contains("Hemköp")){
			this.display_items("Store");
		}else{
			this.display_items("Room");
		}
	}
}