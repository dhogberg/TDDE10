package items;

import the_adventure_2.Player;

public class Tool extends Item {

	public Tool() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean itemCommand(String command, Player player) {
		switch(command) {
			case "tool":
				System.out.println("You have the class tool instanced!");
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			return false;
		}
		return true;
	}
}