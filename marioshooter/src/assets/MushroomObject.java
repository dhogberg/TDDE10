package assets;

import java.awt.image.BufferedImage;
import java.util.Random;
import main.Main;

import assets.XYPoint;

import static constants.Constants.ACTIVEDRAWAREA_WIDTH;
import static constants.Constants.ACTIVEDRAWAREA_HEIGHT;
import static constants.Constants.ACTIVEDRAWAREA_XPOS;
import static constants.Constants.ACTIVEDRAWAREA_YPOS;
import static constants.Constants.PLAYFIELD_HEIGHT;
import static constants.Constants.PLAYFIELD_WIDTH;
import static constants.Constants.PLAYFIELD_YPOS;
import static constants.Constants.PLAYFIELD_XPOS;

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class MushroomObject extends GameObject {
	private XYPoint velocity;
	
	public MushroomObject(String name) {
		super();
		load_objectGraphic_and_calc_dimensions("sprites/mushroom_18x18.png");
		this.set_scale(2.0);
		Random ran = new Random();
		int randomX = PLAYFIELD_XPOS + ran.nextInt( PLAYFIELD_WIDTH + 1 - this.get_width() ) + this.get_width() / 2; // Random integer
		int randomY = PLAYFIELD_YPOS + ran.nextInt( PLAYFIELD_HEIGHT + 1 - this.get_height() ) +  this.get_height() / 2; // Random integer
		this.set_position(randomX, randomY);
		
		this.updateHitbox();
		this.enableHitbox();
		
		this.set_name(name);
		this.set_type_of_object("mushroom");
		
		this.velocity = new XYPoint(0.0, 0.0); this.set_velocity(this.velocity);
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
	
	public void collideWithPlayer() {
		this.disappear();
	}
	
	public void disappear() {
		this.moveOutsideDrawArea();
	}
	
	@Override
	public void update(double executionTime) {
		super.update(executionTime);
	}
}