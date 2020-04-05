package gameobjects;

import java.util.Random;

import codeassets.XYPoint;

import static constants.Constants.PLAYFIELD_HEIGHT;
import static constants.Constants.PLAYFIELD_WIDTH;
import static constants.Constants.PLAYFIELD_YPOS;
import static constants.Constants.PLAYFIELD_XPOS;

/** 
 * 
 * TODO: Represent the item life up. The player gets an extra life when picked up.
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class LifeupObject extends GameObject {
	private XYPoint velocity;

	public LifeupObject(String name) {
		super();
		load_objectGraphic_and_calc_dimensions("src/graphicassets/1up_mushroom_18x18.png");
		this.set_scale(2.0);
		Random ran = new Random();
		int randomX = PLAYFIELD_XPOS + ran.nextInt( PLAYFIELD_WIDTH + 1 - this.get_width() ) + this.get_width() / 2; // Random integer
		int randomY = PLAYFIELD_YPOS + ran.nextInt( PLAYFIELD_HEIGHT + 1 - this.get_height() ) +  this.get_height() / 2; // Random integer
		this.set_position(randomX, randomY);
		this.updateHitbox();
		this.enableHitbox();
		this.set_name(name);
		this.set_type_of_object("1up");
		this.velocity = new XYPoint(0.0, 0.0); this.set_velocity(this.velocity);
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