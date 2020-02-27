package items;

import the_adventure_2.Player;

public class WearableItem extends Item {

	Boolean playerCurrentlyWearingItem = false;
	Integer appearanceFactor = 0; // By default, wearable items do not affect appearance. This can be overwritten in the respective subclass on an item per item basis. 
	
	public WearableItem() {
		// TODO Auto-generated constructor stub
	}
	
	private void appearanceUpdate(Player player, String wearOrTakeOff) {
	
		String increaseOrDecrease = "not changed";
		String stillOrNow = "still";

		if(this.appearanceFactor != 0){
			switch(wearOrTakeOff) {
				case "take off": 
					player.decreaseAppearance(this.appearanceFactor);
					increaseOrDecrease = "decreased";
					stillOrNow = "now";
					break;
				case "wear":
					player.increaseAppearance(this.appearanceFactor);
					increaseOrDecrease = "increased";
					stillOrNow = "now";
					break;
				default:
					// Appearance is the same
			}
		}
		
		System.out.printf(" Your appearance has %s and is %s %s.\n", increaseOrDecrease, stillOrNow, player.getAppearance());
		
	}
	
	@Override
	public boolean itemCommand(String command, Player player) {
		if (command.length() > 5 && command.contains("wear " + this.name)) {
			this.wear(player);
			this.appearanceUpdate(player, "wear");
			return true;
		}else if(command.length() > 9 && command.contains("take off " + this.name)){
			this.takeof(player);
			this.appearanceUpdate(player, "take off");
			return true;
		}else{
			switch(command) {
				case "items":
					System.out.println("You have the class wearableitem instanced!");
					break;
			//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				return false;
			}
			return true;
		}
	}
	
	
	public void wear(Player player) {
		this.playerCurrentlyWearingItem = true;
		System.out.printf("You are now wearing your %s.", this.name);
	}
	
	public void takeof(Player player) {
		this.playerCurrentlyWearingItem = false;
		System.out.printf("You have taken off your %s.", this.name);
	}
	
	@Override
	public void itemHelp(String currentXY, Player player) {
		if(playerCurrentlyWearingItem) {
			System.out.printf("take off %s - Take of your %s\n", this.name, this.name);
		}else {
			System.out.printf("wear %s - Put on your %s\n", this.name, this.name);
		}
		
	}
}