package location;
import java.util.Random;

public class OutdoorsArea extends Location {
	
	public OutdoorsArea(String shortDescription, String longDescription) {
		// Kolla upp vad super betyder! Skriv eventuellt om VVVV
		super(shortDescription, longDescription);
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
		
		System.out.printf(" " + "The weather is %s.\n", randWeather());
	}
	
}