package items;

import the_adventure_2.Player;

public class Flashlight extends Item{

	public Flashlight(Player player) {
		super(player);
		this.name = "flashlight";
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean itemCommand(String command) {
		switch(command) {
			case "flashlight":
				System.out.println("You have a flashlight! :)");
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			return false;
		}
		return true;
	}

}
