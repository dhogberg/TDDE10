package location;

import items.Item;
import the_adventure_2.Player;

public class DarkRoom extends Location {
	
	private Boolean roomIsDark = true;

	public DarkRoom(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}

	@Override
	public String get_typeOfPath(){
		return "door";
	}
	
	
	@Override
	public Boolean take(Player player, Item item) {
		if(!this.roomIsDark) {
			player.giveItem(item);
			player.getLocation().get_items_on_location().remove(item);
			return true;
		}else {
			return false;
		}
	}
	
	
	/*
	@Override
	public Boolean RoomIsDark(){
		if(roomIsDark) {
			return true;
		}else {
			return false;
		}
	}
	*/

	@Override
	public void lookOnLocation(Player player){
		this.displayAvailablePaths(player/*, "DarkRoom"*/);
		if(this.roomIsDark){
			System.out.println("It is too dark to see anything else.");
		}else{
			display_items(); //display_items("DarkRoom");
		}
	}

	/*@Override
	public void display_items_darkroom(){
		if(this.roomIsDark){
			System.out.println("It is too dark to see anything else.");
		}else{
			display_items("DarkRoom");
		}
	}*/

	/*@Override*/
	public void lightenRoom(){
		this.roomIsDark = false;
		System.out.print("The room is now lit.\n");
	}
}