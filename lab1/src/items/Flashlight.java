package items;

import the_adventure_2.Player;

public class Flashlight extends Item{

	public Flashlight() {
		this.name = "flashlight";
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean itemCommand(String command, Player player) {
		switch(command) {
			case "flashlight":
				System.out.println("You have a flashlight! :)");
				player.setPlayerName("Skalman");
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			return false;
		}
		return true;
	}

}
