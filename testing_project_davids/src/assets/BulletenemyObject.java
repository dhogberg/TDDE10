package assets;

import java.awt.image.BufferedImage;
import main.Main;

import assets.XYPoint;

public class BulletenemyObject extends GameObject {
	
	private BufferedImage objectGraphic;
	private XYPoint velocity;
	private boolean falling;
	
	public BulletenemyObject() {
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
	}
	
	public BulletenemyObject(String name) {
		super();
		this.objectGraphic = Main.loadImage("sprites/bullet_enemy_16x14.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(2.0);
		set_objectGraphic_width(16);
		set_objectGraphic_height(14);
		this.set_position(600.0, 400.0);
		this.updateHitbox();
		this.enableHitbox();
		
		this.set_name(name);
		
		this.velocity = new XYPoint(0.0, 0.0); this.set_velocity(this.velocity);
	}
	
	public void collideWithPlayer() {
		this.fallOfScreen();
	}
	
	public void fallOfScreen() {
		this.falling = true;
	}
	
	@Override
	public void update(double executionTime) {
		super.update(executionTime);
		if(this.falling) {
			
			this.velocity.add(new XYPoint(0.0, 5982.0 * executionTime));
			//this.velocity.setY(100.0);


			// UPDATE PARENT OBJECT VELOCITY
			this.set_velocity( this.velocity );
		}
	}
}