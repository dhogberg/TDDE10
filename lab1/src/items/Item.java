package items;

import the_adventure_2.Player;

public class Item {
	private double weight;
	public Player player;
	public String name;
	
	public Item() {
		//
	}

	public void useItem(Player player){
		// override in subclass
	}
	
	public void addBatteries() {
		// override in subclass
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
				if(player.playeritems().isEmpty()){
					System.out.printf("-\n");
				}else{
					for (Item item: player.playeritems()) {
						System.out.printf("■ %s, %skg\n", item.getName(), item.getWeight());	
					}
				}
				
				System.out.print("\nWorn items:\n");
				if(player.wornitems().isEmpty()){
					System.out.printf("-\n");	
				}else{
					for (Item item: player.wornitems()) {
						System.out.printf("■ %s, %skg\n", item.getName(), item.getWeight());	
					}
				}
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				return false;
		}
		return true;
	}
	
	public boolean itemCommand(String command, Player player) {
		// Override in subclasses!
		return false;
	}
	
	public void itemHelp(String currentXY, Player player) {
		System.out.println("items/i - Displays your inventory\n");
	}
}