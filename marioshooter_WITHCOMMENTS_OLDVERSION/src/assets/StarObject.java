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

public class StarObject extends GameObject {
	
	private BufferedImage objectGraphic;
	private XYPoint velocity;
	private boolean falling;
	
	/*
	public LifeupObject() {
		super();
		this.objectGraphic = Main.loadImage("sprites/1up_mushroom_18x18.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(2.0);
		set_objectGraphic_width(18);
		set_objectGraphic_height(18);
		
		Random ran = new Random();
		int randomX = PLAYFIELD_XPOS + ran.nextInt( PLAYFIELD_WIDTH + 1 - this.get_width() ) + this.get_width() / 2; // Random integer
		int randomY = PLAYFIELD_YPOS + ran.nextInt( PLAYFIELD_HEIGHT + 1 - this.get_height() ) +  this.get_height() / 2; // Random integer
		
		this.set_position(randomX, randomY);
		
		this.falling = false;
		this.updateHitbox();
		this.enableHitbox();		
	}
	*/
	
	public StarObject(String name) {
		super();
		this.objectGraphic = Main.loadImage("sprites/star_16x16.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(2.0);
		set_objectGraphic_width(16);
		set_objectGraphic_height(16);
		
		Random ran = new Random();
		int randomX = PLAYFIELD_XPOS + ran.nextInt( PLAYFIELD_WIDTH + 1 - this.get_width() ) + this.get_width() / 2; // Random integer
		int randomY = PLAYFIELD_YPOS + ran.nextInt( PLAYFIELD_HEIGHT + 1 - this.get_height() ) +  this.get_height() / 2; // Random integer
		this.set_position(randomX, randomY);
		
		this.updateHitbox();
		this.enableHitbox();
		
		this.set_name(name);
		this.set_type_of_object("star");
		
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
		if(this.falling) {
			
			//this.velocity.add(new XYPoint(0.0, 5982.0 * executionTime));
			this.velocity.setY(100.0);


			// UPDATE PARENT OBJECT VELOCITY
			this.set_velocity( this.velocity );
		}
	}
}