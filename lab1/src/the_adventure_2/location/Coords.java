package location;

public class Coords {
	int x;
	int y;
	
	public Coords(int startX, int startY) {
		this.x = startX;
		this.y = startY;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	
	public void printCoordsOnScreen() {
		System.out.println("X: " + this.x + "    Y: " + this.y + "\n");
	}

	/*
	public Location getLocationFromCoords(Coords inputCoords) {
		return locationArr[inputCoords.getX()][inputCoords.getY()];
	}
	*/
	
	public Coords newCoordXY(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
}