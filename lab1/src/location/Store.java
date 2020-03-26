package location;

import the_adventure_2.Player;

public class Store extends Room {

	public Store(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}

	@Override
	public String get_typeOfGround(){
		return "shelves";
	}

}