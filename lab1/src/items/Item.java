package items;

import the_adventure_2.Player;

public class Item {
	private double weight;
	public Player player;
	public String name;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean itemCommand(String command, Player player) {
		switch(command) {
			case "item ":
				System.out.println("Itemcommand runs!!! WOOO :)");
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			return false;
		}
		return true;
	}
}