package items;

import the_adventure_2.Player;

public class Item {
	private double weight;
	public Player player;
	public String name;
	
	public Item() {
		//
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Double getWeight() {
		return this.weight;
	}
	
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public boolean itemSpecialCommand(String command, Player player) {
		switch(command) {
		case "items": case "i":
			System.out.print("Items:\n");
			for (Item item: player.playeritems()) {
				System.out.printf("■ %s, %skg\n", item.getName(), item.getWeight());	
			}
			break;
		default:
			return false;
		}
		return true;
	}
	
	public boolean itemCommand(String command, Player player) {
		// Override in subclasses!
	}
	
	public void itemHelp(String currentXY, Player player) {
		System.out.println("items/i - Displays your inventory\n");
	}
}