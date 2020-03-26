package location;

import the_adventure_2.Player;

public class Room extends Location {
	
	public Room(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}
	
	@Override
	public String get_typeOfPath(){
		return "door";
	}
	@Override
	public String get_typeOfGround(){
		return "floor";
	}

  //Kommentar: Detta borde inte skötas med en if-sats. Om ni 
  //skulle ha flera rum med olika funktionalitet blir det väldigt 
  //lång if-sats. Låt istället ansvaret för hemköps funktionalitet
  //ligga i klassen Hemköp. Ni har uppvisat detta på andra
  //ställen i koden så jag låter det gå som endast en kommentar.
	@Override
	public void lookOnLocation(Player player){
		this.displayAvailablePaths(player/*, "Room"*/);
		this.display_items();
		/*if(this.shortDescription().contains("Hemköp")){
			this.display_items("Store");
		}else{
			this.display_items("Room");
		}*/
	}
}
