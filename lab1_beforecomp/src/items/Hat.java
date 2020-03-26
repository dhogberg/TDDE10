package items;

public class Hat extends WearableItem{
	public Hat(String name, Double weight) {
		this.setName(name);
		this.setWeight(weight);
		this.appearanceFactor = 1;
	}
}