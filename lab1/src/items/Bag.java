package items;

import the_adventure_2.Player;

public class Bag extends WearableItem{

	public Bag(String name, Double weight) {
		this.setName(name);
		this.setWeight(weight);
	}
	
	/*
	@Override
	public boolean itemCommand(String command, Player player) {
		switch(command) {
			case "items": case "i":
				System.out.print("Items:\n");
				for (Item item: player.playeritems()) {
					System.out.printf("■ %s, %skg\n", item.getName(), item.getWeight());	
				}
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			return false;
		}
		return true;
	}*/
	
	/*@Override
	public void itemHelp(String currentXY, Player player) {
		System.out.println("items/i - Displays your inventory");
	}*/
}