package items;

public class Jacket extends WearableItem{ 
	
	public Jacket(String name, Double weight) {
		this.setName(name);
		this.setWeight(weight);
		this.appearanceFactor = 2;
	}
}