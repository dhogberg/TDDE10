package location;

public class DarkRoom extends Location {
	
	Boolean roomIsDark = true;

	public DarkRoom(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}

	@Override
	public void lookOnLocation(){
		this.displayAvailablePaths();
		this.display_items_darkroom();
	}

	@Override
	public void displayAvailablePaths(){
		System.out.println("Darkroom: You are outdoor, there is a road leading bla bla bla");
	}

	@Override
	public void display_items_darkroom(){
		if(this.roomIsDark){
			System.out.println("Darkroom: Now you cant see the jacket, it's too dark!");
		}else{
			System.out.println("Litroom: Now you can see the jacket!");
		}
	}

	@Override
	public void lightenRoom(){
		this.roomIsDark = false;
	}
}