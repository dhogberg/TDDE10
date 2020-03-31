package assets;

import constants.Constants;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public abstract class GameObject {
	
	private BufferedImage objectGraphic;
	private int objectGraphic_width;
	private int objectGraphic_height;
	private XYPoint position;
	private XYPoint velocity;
	private double scale;	
	
	public GameObject() {
		this.position = new XYPoint();
		this.velocity = new XYPoint();
		this.scale = 1.0;
	}
	
	public void draw(Graphics2D g2d) {
		this.drawObject(g2d);
	}
	
	public void update(double executionTime) {
		this.updatePosition(executionTime);
	}
	
	public void updatePosition(double executionTime) {
		this.position.add(this.velocity.multiply(executionTime));
	}
	
	public void drawObject(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(this.get_objectGraphic(), position.x() - get_objectGraphic_scaledWidth() / 2, position.y() - get_objectGraphic_scaledHeight() / 2, get_objectGraphic_scaledWidth(), get_objectGraphic_scaledHeight(), null);
	}
	
	public BufferedImage get_objectGraphic() {
		return this.objectGraphic;
	}
	
	public void set_objectGraphic(BufferedImage image) {
		this.objectGraphic = image;
	}
	
	public int get_objectGraphic_scaledWidth() {
		return (int) Math.round( scale * this.objectGraphic_width ); 
	}
	
	public int get_objectGraphic_scaledHeight() {
		return (int) Math.round( scale * this.objectGraphic_height ); 
	}
	
	public void set_objectGraphic_width(int w) {
		this.objectGraphic_width = w;
	}
	
	public void set_objectGraphic_height(int h) {
		this.objectGraphic_height = h;
	}
	
	public void set_scale(double s) {
		this.scale = s;
	}
	
	public void set_position(XYPoint new_position) {
		this.position = new_position;
	}
	
	public XYPoint get_position() {
		return this.position;
	}
	
	// TODO: Remove method, not needed ?
	public void set_position(double x, double y) {
		this.position.setX(x);
		this.position.setY(y);
	}
	
	public void set_velocity(double x, double y) {
		this.velocity.setX(x);
		this.velocity.setY(y);
	}
	
	public void set_velocity(XYPoint new_velocity) {
		this.velocity = new_velocity;
	}
	
	public XYPoint velocity() {
		return this.velocity;
	}
}