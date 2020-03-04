package location;

public class Room extends Location {
	
	public Room(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}
	
	@Override
	public void lookOnLocation(){
		this.displayAvailablePaths();
		this.display_items();
	}

	@Override
	public void displayAvailablePaths(){
		System.out.println("ROOM: You are in a room, there is a door leading bla bla bla");
	}
}