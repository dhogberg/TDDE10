package items;

import the_adventure_2.Player;

public class Tool extends Item {

	public Tool() {
		//
	}

	@Override
	public void useItem(Player player){
		// override in subclass
	}
	
	@Override
	public void addBatteries() {
		// override in subclass
	}

	@Override
	public boolean itemCommand(String command, Player player) {
		switch(command) {
			case "tool":
				System.out.println("You have the class tool instanced!");
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				if (command.length() > 4) {
					if(command.startsWith("use")) {
						for (Item item: player.playeritems()) {
							if(command.substring(4).equals(item.name)) {
								item.useItem(player);
								return true;
							}
						}
					}
				}
				return false;
		}
		return true;
	}
}