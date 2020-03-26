package items;

import the_adventure_2.Player;

public class Batteries extends Tool{ 
	
	public Batteries(String name, Double weight) {
		this.setName(name);
		this.setWeight(weight);
	}
	
	public void useItem(Player player){
		if(!this.useBatteries(player)){
			System.out.println("Could not use batteries - You don't have any item to use them on.");
		}
	}
	
	private boolean useBatteries(Player player) {
		for (Item item: player.playeritems()) {
			if(item.getName().contains("flashlight")) {
				item.itemCommandV2("addBatteries", player); //item.addBatteries(); // Add batteries to flashlight
				player.removePlayeritem(this); // Remove batteries from player inventory
				System.out.print("Success! The flashlight now has batteries.\n");
				return true;
			}
		}
		return false;
	}

	public boolean itemCommandV2(String command, Player player) {
		switch(command) {
			/*case "itemcmdv2":
				System.out.println("Itemcommand 2 works!");
				break;*/
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				if (command.length() > 4) {
					if(command.startsWith("use")) {
						if(command.substring(4).equals(this.getName())) {
							this.useItem(player);
							return true;
						}
					}
				}
				return false;
		}
		//return true;
	}
	
	@Override
	public void itemHelp(String currentXY, Player player) {
		System.out.println("use batteries - Maybe these could be useful...");
	}

}
