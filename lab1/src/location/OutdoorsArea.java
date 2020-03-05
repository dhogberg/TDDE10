package location;

import java.util.Random;
import the_adventure_2.Player;

public class OutdoorsArea extends Location {
	
	public OutdoorsArea(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}
	
	@Override
	public void lookOnLocation(Player player){
		this.displayAvailablePaths(player, "OutdoorsArea");
		this.display_items("OutdoorsArea");
	}

	private String randWeather() {
		Random r = new Random();
		
		String[] list = {
			"sunny",
			"rainy",
			"cloudy",
			"quiet nice",
			"chilly",
			"windy",
			"soft",
			"very windy"
		};
		
		return list[r.nextInt(list.length)];
	}
	
	public void printWeather() {
		System.out.printf(" " + "The weather is %s.", randWeather());
	}
	
	@Override
	public void describeYourself() {
		super.describeYourself();
	}
	
}