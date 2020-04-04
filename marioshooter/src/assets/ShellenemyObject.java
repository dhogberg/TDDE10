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
 * TODO: Represent a shell.
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class ShellenemyObject extends GameObject {
	
	private BufferedImage objectGraphic;
	private XYPoint velocity;
	private boolean sliding;
	private boolean stopped;
	
	public ShellenemyObject(String name) {
		super();
		
		this.objectGraphic = Main.loadImage("sprites/shell_16x16.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(2.0);
		set_objectGraphic_width(16);
		set_objectGraphic_height(16);
		this.sliding = false;
		this.stopped = false;
		
		Random ran = new Random();
		int randomHeight = PLAYFIELD_YPOS + ran.nextInt( PLAYFIELD_HEIGHT + 1 - this.get_height() ) +  this.get_height() / 2; // Random integer 
		
		this.set_position(PLAYFIELD_XPOS + PLAYFIELD_WIDTH + this.get_width(), randomHeight);
		
		this.velocity = new XYPoint(-120.0, 0.0); this.set_velocity(this.velocity);
		
		this.updateHitbox();
		this.enableHitbox();
		
		this.set_name(name);
		this.set_type_of_object("shellenemy");
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
	
	@Override
	public void collideWithGameobject(GameObject obj) {
		switch(obj.get_type_of_object()) {
			case "playerbullet":
				
				if(!this.stopped){
					this.stopped = true;
					this.velocity.setX(0.0);
				}else{
					this.disableHitbox();
					this.sliding = true;
				}
				System.out.println("Enemybullet has collided with a playerbullet!");
				break; 
			default:
				System.out.println("Enemybullet has collided with something!");
		}
	}
	
	public void slideOfScreen() {
		this.sliding = true;
		this.velocity.setX(0.0);
	}
	
	@Override
	public void update(double executionTime) {
		super.update(executionTime);
		if(this.sliding) {
			
			this.velocity.setX(2000.0);
			
			// UPDATE PARENT OBJECT VELOCITY
			this.set_velocity( this.velocity );
		}
	}
}