package items;

import the_adventure_2.Player;

public class Flashlight extends Tool{

	Boolean hasBatteries = false; 
	
	public Flashlight(String name, Double weight) {
		this.setName(name);
		this.setWeight(weight);
	}
	
	@Override
	public void useItem(Player player){
		this.useFlashlight(player);
	}

	private void useFlashlight(Player player) {
		player.getLocation().lightenRoom();

		if(!hasBatteries) {
			System.out.print("Nothing happened. The flashlight is missing batteries.\n");
		}else {
			System.out.print("Damn, that's bright. That's bright.");
		}
	}
	
	@Override
	public void addBatteries() {
		this.hasBatteries = true;
	}
	
	@Override
	public void itemHelp(String currentXY, Player player) {
		System.out.println("use flashlight - Turn on flashlight");
	}

}
