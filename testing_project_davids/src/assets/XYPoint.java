package assets;

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
	
	public int x() {
		return (int) Math.round(this.x);
	}
	
	public int y() {
		return (int) Math.round(this.y);
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
		System.out.printf("VAD FAN this.y: %s delta.y %s total: %s \n",this.y(), delta.y(), this.y() - delta.y());
		this.setX(this.x() - delta.x());
		this.setY(this.y() - delta.y());
	}

}
