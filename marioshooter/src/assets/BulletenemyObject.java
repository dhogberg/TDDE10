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

public class BulletenemyObject extends GameObject {
	
	private BufferedImage objectGraphic;
	private XYPoint velocity;
	private boolean falling;
	
	/*public BulletenemyObject() {
		super();
		this.objectGraphic = Main.loadImage("sprites/bullet_enemy_16x14.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(2.0);
		set_objectGraphic_width(16);
		set_objectGraphic_height(14);
		this.set_position(600.0, 400.0);
		this.falling = false;
		this.updateHitbox();
		this.enableHitbox();
	}*/
	
	public BulletenemyObject(String name) {
		super();
		
		
		
		this.objectGraphic = Main.loadImage("sprites/bullet_enemy_16x14.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(2.0);
		set_objectGraphic_width(16);
		set_objectGraphic_height(14);
		
		Random ran = new Random();
		int randomHeight = PLAYFIELD_YPOS + ran.nextInt( PLAYFIELD_HEIGHT + 1 - this.get_height() ) +  this.get_height() / 2; // Random integer 
		
		this.set_position(PLAYFIELD_XPOS + PLAYFIELD_WIDTH + this.get_width(), randomHeight);
		
		
		this.velocity = new XYPoint(-400.0, 0.0); this.set_velocity(this.velocity);
		
		/*
		PLAYFIELD_WIDTH;
		import static constants.Constants.PLAYFIELD_HEIGHT;
		import static constants.Constants.PLAYFIELD_XPOS;
		import static constants.Constants.PLAYFIELD_YPOS;
		*/
		
		
		this.updateHitbox();
		this.enableHitbox();
		
		this.set_name(name);
		this.set_type_of_object("bulletenemy");
		
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
			
			//this.velocity.add(new XYPoint(0.0, 5982.0 * executionTime));
			this.velocity.setY(100.0);


			// UPDATE PARENT OBJECT VELOCITY
			this.set_velocity( this.velocity );
		}
	}
}