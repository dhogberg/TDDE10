package items;

import the_adventure_2.Player;

//TODO[FIXED]: Komplettering: Istället för att dessa
//metoder ska vara tomma, låt Tools vara abstrakt.

public abstract class Tool extends Item {

	public Tool() {
		//
	}

	//public abstract void useItem(Player player);

	//public abstract void addBatteries();

	
	/*@Override
	public void useItem(Player player){
		// override in subclass
	}*/
	public abstract void useItem(Player player);

	/*
	@Override
	public void addBatteries() {
		// override in subclass
	}*/
	
	//public abstract void addBatteries();


	public abstract boolean itemCommandV2(String command, Player player);

	/*@Override
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
							if(command.substring(4).equals(item.getName())) {
								item.useItem(player);
								return true;
							}
						}
					}
				}
				return false;
		}
		return true;
	}*/
}