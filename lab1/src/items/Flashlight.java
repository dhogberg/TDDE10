package items;

import the_adventure_2.Player;

//Kommentar: Här skiljer sig funktionaliteten
//ifrån Tool och då är det superbra att ni har
//en egen klass till Flashlight. 

public class Flashlight extends Tool{

	private Boolean hasBatteries = false; 
	
	public Flashlight(String name, Double weight) {
		this.setName(name);
		this.setWeight(weight);
	}
	
	/*@Override*/
	public void useItem(Player player){
		this.useFlashlight(player);
	}

	private void useFlashlight(Player player) {
		if(!hasBatteries) {
			System.out.print("Nothing happened. The flashlight is missing batteries.\n");
		}else {
			System.out.print("Damn, that's bright. That's bright.\n");
			//player.getLocation().lightenRoom();
		}
	}
	
	/*@Override*/
	public void addBatteries() {
		this.hasBatteries = true;
	}

	public boolean itemCommandV2(String command, Player player) {
		switch(command) {
			case "addBatteries":
				this.addBatteries();
				break;
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
		return true;
	}
	
	@Override
	public void itemHelp(String currentXY, Player player) {
		System.out.println("use flashlight - Turn on flashlight");
	}

}
