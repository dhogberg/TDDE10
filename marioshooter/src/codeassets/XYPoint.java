package codeassets;

/** 
 * 
 * A class that can hold XY coordinates and methods to interact with the coordinates
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class XYPoint {

	private double x;
	private double y;
	
	public XYPoint() {
		this.x = 0;
		this.y = 0;
	}
	
	public XYPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public int x_as_int() {
		return (int) Math.round(this.x);
	}
	
	public int y_as_int() {
		return (int) Math.round(this.y);
	}

	public double x() {
		return this.x;
	}
	
	public double y() {
		return this.y;
	}
	
	public void setX (double x) {
		this.x = x;
	}
	
	public void setY (double y) {
		this.y = y;
	}
	
	public XYPoint multiply(double constant) {
		return new XYPoint(constant * this.x(), constant * this.y());
	}

	public void add(XYPoint delta) {
		this.setX(this.x() + delta.x());
		this.setY(this.y() + delta.y());
	}
	
	public void subtract(XYPoint delta) {
		this.setX(this.x() - delta.x());
		this.setY(this.y() - delta.y());
	}

}