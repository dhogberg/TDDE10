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

public class PlayerbulletObject extends GameObject {
	
	private BufferedImage objectGraphic;
	private XYPoint velocity;
	private boolean falling;
	private PlayerObject player_reference;
	
	public PlayerbulletObject(PlayerObject player, int x, int y) {
		super();
		
		this.player_reference = player;
		this.objectGraphic = Main.loadImage("sprites/bullet_enemy_16x14.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(2.0);
		set_objectGraphic_width(16);
		set_objectGraphic_height(14);
		
		this.set_position(x, y);
		
		this.velocity = new XYPoint(2000.0, 0.0); this.set_velocity(this.velocity);
		
		this.updateHitbox();
		this.enableHitbox();
		
		this.set_type_of_object("playerbullet");
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
			case "bulletenemy":
				this.disableHitbox();
				this.moveOutsideDrawArea();
				
				player_reference.add_score(10);
				
				//obj.moveOutsideDrawArea();
				System.out.println("PLAYERBULLET has collided with a ENEMYBULLET!");
				
				break;
			case "1up":
				break;
			// 
			default:
				System.out.println("PLAYERBULLET has collided with something!");
		}
	}

	/*
	public void collideWithPlayer() {
		this.fallOfScreen();
	}
	*/
	
	@Override
	public void update(double executionTime) {
		super.update(executionTime);
		
		/*if(this.falling) {
			
			this.velocity.add(new XYPoint(0.0, 5982.0 * executionTime)); // FOR DEVELOPMENT //this.velocity.setY(100.0);

			// UPDATE PARENT OBJECT VELOCITY
			this.set_velocity( this.velocity );
		}
		*/
	}
}