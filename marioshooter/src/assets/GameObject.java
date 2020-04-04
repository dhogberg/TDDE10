package assets;

import constants.Constants;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import assets.Imageloader;

import static constants.Constants.ACTIVEDRAWAREA_WIDTH;
import static constants.Constants.ACTIVEDRAWAREA_HEIGHT;
import static constants.Constants.ACTIVEDRAWAREA_XPOS;
import static constants.Constants.ACTIVEDRAWAREA_YPOS;

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public abstract class GameObject {
	
	private BufferedImage objectGraphic;
	private int objectGraphic_width;
	private int objectGraphic_height;
	private XYPoint position;
	private XYPoint velocity;
	private HitBox hitbox;
	private double scale;
	private String type_of_object;
	private String name; // Used in development so we can identify different objects
	
	public GameObject() {
		this.type_of_object = null;
		this.position = new XYPoint();
		this.velocity = new XYPoint();
		this.hitbox = new HitBox();
		this.scale = 1.0;
	}
	
	public boolean outsideDrawingArea() {
		if(
			this.get_position().x_as_int() < ACTIVEDRAWAREA_XPOS || 
			this.get_position().x_as_int() > ACTIVEDRAWAREA_XPOS + ACTIVEDRAWAREA_WIDTH || 
			this.get_position().y_as_int() < ACTIVEDRAWAREA_YPOS || 
			this.get_position().y_as_int() > ACTIVEDRAWAREA_YPOS + ACTIVEDRAWAREA_HEIGHT
		) {
			return true;
		}else {
			return false;
		}
	}
	
	public void moveOutsideDrawArea(){
		this.position = new XYPoint(ACTIVEDRAWAREA_WIDTH + ACTIVEDRAWAREA_XPOS + 1, ACTIVEDRAWAREA_HEIGHT + ACTIVEDRAWAREA_YPOS + 1);
	}

	public void set_name(String name) {
		this.name = name;
	}
	
	public String get_type_of_object() {
		return this.type_of_object;
	}
	
	public void set_type_of_object(String type_of_object) {
		this.type_of_object = type_of_object;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public void draw(Graphics2D g2d) {
		this.drawObject(g2d);
	}
	
	public void update(double executionTime) {
		// UPDATE POSITION
		this.updatePosition(executionTime);

		// UPDATE HITBOX
		this.hitbox.update(this.get_leftupperXY(), get_rightlowerXY());
	}
	
	public void updatePosition(double executionTime) {
		this.position.add(this.velocity.multiply(executionTime));
	}
	
	public void collideWithPlayer() {
		// By default do nothing
	}
	
	public void collideWithGameobject(GameObject obj) {
		// By default do nothing
	}
	
	public void updateHitbox() {
		this.hitbox.update(this.get_leftupperXY(), this.get_rightlowerXY());
	}

	public HitBox hitbox(){
		return this.hitbox;
	}
	
	public void enableHitbox() {
		this.hitbox.enable();
	}
	
	public void disableHitbox() {
		this.hitbox.disable();
	}
	
	public void drawObject(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(this.get_objectGraphic(), position.x_as_int() - get_objectGraphic_scaledWidth() / 2, position.y_as_int() - get_objectGraphic_scaledHeight() / 2, get_objectGraphic_scaledWidth(), get_objectGraphic_scaledHeight(), null);
	}
	
	public BufferedImage get_objectGraphic() {
		return this.objectGraphic;
	}
	
	public void set_objectGraphic(BufferedImage image) {
		this.objectGraphic = image;
	}
	
	public void load_objectGraphic_and_calc_dimensions(String image_path){
		this.objectGraphic = Imageloader.loadImage(image_path);
		set_objectGraphic_width(this.objectGraphic.getWidth());
		set_objectGraphic_height(this.objectGraphic.getHeight());
	}

	public XYPoint get_leftupperXY(){
		final int x = this.position.x_as_int() - (this.get_width() / 2);
		final int y = this.position.y_as_int() - (this.get_height() / 2);
		
		return new XYPoint(x, y);
	}

	public XYPoint get_rightlowerXY(){
		final int x = this.position.x_as_int() + (this.get_width() / 2);
		final int y = this.position.y_as_int() + (this.get_height() / 2);
		
		return new XYPoint(x, y);
	}

	public int get_width() {
		return (int) Math.round( scale * this.objectGraphic_width ); 
	}
	
	public int get_height() {
		return (int) Math.round( scale * this.objectGraphic_height ); 
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
	
	public double get_scale() {
		return this.scale;
	}
	
	public void set_position(XYPoint new_position) {
		this.position = new_position;
	}
	
	public XYPoint get_position() {
		return this.position;
	}

	public void set_position(double x, double y) {
		this.position.setX(x);
		this.position.setY(y);
	}
	
	public void set_position(int x, int y) {
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