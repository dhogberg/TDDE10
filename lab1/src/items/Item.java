package items;

import the_adventure_2.Player;

public class Item {
	private double weight;
	private Player player;
	public String name;
	
	public Item(Player player) {
		this.player = player;
		// TODO Auto-generated constructor stub
	}
	
	public boolean itemCommand(String command) {
		switch(command) {
			case "item":
				System.out.println("Itemcommand runs!!! WOOO :)");
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			return false;
		}
		return true;
	}
}