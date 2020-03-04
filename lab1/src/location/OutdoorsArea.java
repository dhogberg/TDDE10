package location;
import java.util.Random;

public class OutdoorsArea extends Location {
	
	public OutdoorsArea(String shortDescription, String longDescription) {
		super(shortDescription, longDescription);
	}
	
	@Override
	public void lookOnLocation(){
		this.displayAvailablePaths();
		this.display_items();
	}

	@Override
	public void displayAvailablePaths(){
		System.out.println("OutdoorsArea: You are outdoor, there is a road leading bla bla bla");
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