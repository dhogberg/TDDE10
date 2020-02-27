package items;

import the_adventure_2.Player;

public class Batteries extends Tool{ 
	
	public Batteries(String name, Double weight) {
		this.setName(name);
		this.setWeight(weight);
	}
	
	
	private void useBatteries() {
		System.out.print("USE BATTERIES - NOT IMPLEMENTED YET\n\n");
	}
	



	/* Detta ska flyttas till Tool.java */
	/* Detta ska flyttas till Tool.java */
	@Override
	public boolean itemCommand(String command, Player player) {
		switch(command) {
			case "use batteries":
				useBatteries();
				break;
		//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
		default:
			return false;
		}
		return true;
	}
	/* Detta ska flyttas till Tool.java */
	/* Detta ska flyttas till Tool.java */




	
	@Override
	public void itemHelp(String currentXY, Player player) {
		System.out.println("use batteries - Maybe these could be useful...");
	}

}
