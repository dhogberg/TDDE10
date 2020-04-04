package assets;

import java.awt.image.BufferedImage;
import java.util.Random;
import main.Main;

import assets.XYPoint;

import static constants.Constants.ACTIVEDRAWAREA_WIDTH;
import static constants.Constants.ACTIVEDRAWAREA_HEIGHT;
import static constants.Constants.ACTIVEDRAWAREA_XPOS;
import static constants.Constants.ACTIVEDRAWAREA_YPOS;

import static constants.Constants.PLAYFIELD_WIDTH;
import static constants.Constants.PLAYFIELD_HEIGHT;
import static constants.Constants.PLAYFIELD_XPOS;
import static constants.Constants.PLAYFIELD_YPOS;

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class BulletenemyObject extends GameObject {
	private XYPoint velocity;
	private boolean falling;
	
	public BulletenemyObject(String name) {
		super();
		load_objectGraphic_and_calc_dimensions("sprites/bullet_enemy_16x14.png");
		this.set_scale(2.0);
		Random ran = new Random();
		int randomHeight = PLAYFIELD_YPOS + ran.nextInt( PLAYFIELD_HEIGHT + 1 - this.get_height() ) +  this.get_height() / 2; // Random integer 
		
		this.set_position(PLAYFIELD_XPOS + PLAYFIELD_WIDTH + this.get_width(), randomHeight);
		
		this.velocity = new XYPoint(-120.0, 0.0); this.set_velocity(this.velocity);
		
		this.updateHitbox();
		this.enableHitbox();
		
		this.set_name(name);
		this.set_type_of_object("bulletenemy");
	}
	
	@Override
	public void collideWithGameobject(GameObject obj) {
		switch(obj.get_type_of_object()) {
			case "playerbullet":
				this.disableHitbox();
				this.fallOfScreen();
				System.out.println("Enemybullet has collided with a playerbullet!");
				break;
			default:
				System.out.println("Enemybullet has collided with something!");
		}
	}
	
	public void collideWithPlayer() {
		this.fallOfScreen();
	}
	
	public void fallOfScreen() {
		this.falling = true;
		this.velocity.setX(0.0);
	}
	
	@Override
	public void update(double executionTime) {
		super.update(executionTime);
		if(this.falling) {
			
			this.velocity.add(new XYPoint(0.0, 5982.0 * executionTime)); // FOR DEVELOPMENT //this.velocity.setY(100.0);
			
			// UPDATE PARENT OBJECT VELOCITY
			this.set_velocity( this.velocity );
		}
	}
}