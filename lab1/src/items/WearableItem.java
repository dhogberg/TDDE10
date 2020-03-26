package items;

import the_adventure_2.Player;

public class WearableItem extends Item {

  //TODO[FIXAD]: Komplettering: Ni ska inte ha några publika 
  //instansvariabler. Se över detta i hela programmet.
	// ---- FIXAT ----
	// ---- FIXAT ----

	private Boolean playerCurrentlyWearingItem = false;
	private Integer appearanceFactor = 0; // By default, wearable items do not affect appearance. This can be overwritten in the respective subclass on an item per item basis. 
	
	public WearableItem(String name, Double weight, Integer appearanceFactor) {
		this.setName(name);
		this.setWeight(weight);
		this.set_appearanceFactor(appearanceFactor);
	}

	public WearableItem(String name, Double weight) {
		this.setName(name);
		this.setWeight(weight);
	}

	public Integer get_appearanceFactor(){
		return this.appearanceFactor;
	}

	public void set_appearanceFactor(Integer x){
		this.appearanceFactor = x;
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
			//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
				default:
					// Appearance is the same
			}
		}
		
		System.out.printf(" Your appearance has %s and is %s %s.\n", increaseOrDecrease, stillOrNow, player.getAppearanceFriendlyname());
		
	}
	
	/*
	@Override
	public boolean itemCommand(String command, Player player) {
		if (command.length() > 5 && command.contains("wear " + this.getName())) {
			if(!this.playerCurrentlyWearingItem){
				player.wearItem(this);
				this.wear(player);
				this.appearanceUpdate(player, "wear");
			}else{
				System.out.printf("You are already wearing your %s!\n", this.getName());
			}
			return true;
			
		}else if(command.length() > 9 && command.contains("take off " + this.getName())){
			if(this.playerCurrentlyWearingItem){
				player.takeoffItem(this);
				this.takeof(player);
				this.appearanceUpdate(player, "take off");
			}else{
				System.out.printf("You are not wearing your %s!\n", this.getName());
			}
			return true;
		}else{
			switch(command) {
				case "items":
					// @Override in subclasses
					//System.out.println("You have the class wearableitem instanced!");
					break;
			//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
				default:
					return false;
			}
			return true;
		}
	}*/


	public boolean itemCommandV2(String command, Player player) {
		if (command.length() > 5 && command.contains("wear " + this.getName())) {
			if(!this.playerCurrentlyWearingItem){
				player.wearItem(this);
				this.wear(player);
				this.appearanceUpdate(player, "wear");
			}else{
				System.out.printf("You are already wearing your %s!\n", this.getName());
			}
			return true;
			
		}else if(command.length() > 9 && command.contains("take off " + this.getName())){
			if(this.playerCurrentlyWearingItem){
				player.takeoffItem(this);
				this.takeof(player);
				this.appearanceUpdate(player, "take off");
			}else{
				System.out.printf("You are not wearing your %s!\n", this.getName());
			}
			return true;
		}else{
			switch(command) {
				case "items":
					// @Override in subclasses
					//System.out.println("You have the class wearableitem instanced!");
					break;
			//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
				default:
					/*if (command.length() > 4) {
						if(command.startsWith("use")) {
							if(command.substring(4).equals(this.getName())) {
								this.useItem(player);
								return true;
							}
						}
					}*/
					return false;
			}
			return true;
		}
	}
	
	
	public void wear(Player player) {
		this.playerCurrentlyWearingItem = true;
		System.out.printf("You are now wearing your %s.", this.getName());
	}
	
	public void takeof(Player player) {
		this.playerCurrentlyWearingItem = false;
		System.out.printf("You have taken off your %s.", this.getName());
	}
	
	@Override
	public void itemHelp(String currentXY, Player player) {
		if(playerCurrentlyWearingItem) {
			System.out.printf("take off %s - Take of your %s\n", this.getName(), this.getName());
		}else {
			System.out.printf("wear %s - Put on your %s\n", this.getName(), this.getName());
		}
		
	}
}
