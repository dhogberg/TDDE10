package location;

public class DarkRoom extends Location {
	
	Boolean roomIsDark = true;

	public DarkRoom(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}

	@Override
	public void lightenRoom(){
		this.roomIsDark = false;
	}

	public void darkenRoom(){
		this.roomIsDark = true;
	}
	
	@Override
	public void displayAvailablePaths(){
		if(roomIsDark){
			System.out.println("The room is dark...");
		}else{
			System.out.println("The room is lit! :)");
		}
		//System.out.println("You are in a darkroom, there is a door leading bla bla bla");
	}
}