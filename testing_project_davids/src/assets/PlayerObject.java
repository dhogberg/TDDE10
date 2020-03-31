package assets;

import java.awt.image.BufferedImage;
import java.util.Set;
import main.Main;
import assets.XYPoint;

public class PlayerObject extends GameObject {

	private BufferedImage objectGraphic;
	private XYPoint position;
	private XYPoint velocity;
	
	public PlayerObject() {
		super();
		this.objectGraphic = Main.loadImage("sprites/life_mushroom_18x18.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(10.0);
		set_objectGraphic_width(18);
		set_objectGraphic_height(18);
		this.set_position(90.0, 90.0);
		this.velocity = new XYPoint(0.0, 0.0); this.set_velocity(this.velocity);
		this.updateHitbox();
		this.enableHitbox();
	}
	
	public double makePos(double d) {
		if(d != 0.0) {
			if(d < 0.0) {
				return d * -1.0;
			}else {
				return d;
			}
		}
		return d;
	}
	
	/*
	@Override
	public void update(double executionTime) {
		super.update(executionTime);
		// TODO: Update specific things for the playerObject
		
		if(this.get_position().x() > 1510.0) {
			this.get_velocity().setY(this.get_velocity().x());
			this.get_velocity().setX(0.0);
			this.get_position().setX(1510.0);
			this.set_velocity(this.get_velocity().multiply(1.25));
		}else if(this.get_position().y() > 810.0) {
			this.get_velocity().setX(this.get_velocity().y() * -1.0);
			this.get_velocity().setY(0.0);
			this.get_position().setY(810.0);
			this.set_velocity(this.get_velocity().multiply(1.25));
		}else if(this.get_position().x() < 90.0) {
			this.get_velocity().setY(this.get_velocity().x());
			this.get_velocity().setX(0.0);
			this.get_position().setX(90.0);
			this.set_velocity(this.get_velocity().multiply(1.25));
		}else if(this.get_position().y() < 90.0) {
			this.get_velocity().setX(this.get_velocity().y() * -1.0);
			this.get_velocity().setY(0.0);
			this.get_position().setY(90.0);
			this.set_velocity(this.get_velocity().multiply(1.25));
		}
	}
	*/
	
	public void update(double executionTime, Set<Integer> active_keys) {
		
		super.update(executionTime);
		
		if(active_keys.contains(40)) { // KEYDOWN
			if(this.velocity.y() != 0.0) {
				
				if(this.velocity.y() < 0.0) {
					this.velocity.setY(0.0);
				}

			}
			this.velocity.add(new XYPoint(0.0, 5982.0 * executionTime));
		}
		
		if(active_keys.contains(38)) { // KEYUP	
			if(this.velocity.y() != 0.0) {
				if(this.velocity.y() > 0.0) {
					this.velocity.setY(0.0);
				}
			}
			this.velocity.subtract(new XYPoint(0.0, 5982.0 * executionTime));
		}
		
		if(active_keys.contains(37)) { // KEYLEFT	
			if(this.velocity.x() != 0.0) {
				if(this.velocity.x() > 0.0) {
					this.velocity.setX(0.0);
				}
			}
			this.velocity.subtract(new XYPoint(5982.0 * executionTime, 0.0));
		}
		
		if(active_keys.contains(39)) { // KEYRIGHT	
			if(this.velocity.x() != 0.0) {
				if(this.velocity.x() < 0.0) {
					this.velocity.setX(0.0);
				}
			}
			this.velocity.add(new XYPoint(5982.0 * executionTime, 0.0));
		}
		
		// REMOVE ACCELERATION BASED ON TIME
		//this.acceleration.subtract(new XYPoint(0.0, this.acceleration.y() / 2 * executionTime));
		
		// SUBTRACT VELOCITY WITH TIME
		/*
		final double subtraction_constant = 500.0;
		
		if(this.velocity.y() != 0.0) {
			if(this.velocity.y() < 0.0) {
				if(makePos(this.velocity.y()) < (subtraction_constant * executionTime)) {
					this.velocity.setY(0.0);
				}else {
					this.velocity.setY( this.velocity.y() + subtraction_constant * executionTime );
				}
			}else if(this.velocity.y() > 0.0){
				
				if(makePos(this.velocity.y()) < (subtraction_constant * executionTime)) {
					this.velocity.setY(0.0);
				}else {
					this.velocity.setY( this.velocity.y() - subtraction_constant * executionTime );
				}	
			}	
		}
		*/
		
		
		
		// RESTRICT PLAYER TO PLAYFIELD
		if(this.get_position().y() > 810.0) {
			this.velocity.setY(0.0);
			this.get_position().setY(810.0);
		}else if(this.get_position().y() < 90.0) {
			this.velocity.setY(0.0);
			this.get_position().setY(90.0);
		}else if(this.get_position().x() < 90.0) {
			this.velocity.setX(0.0);
			this.get_position().setX(90.0);
		}else if(this.get_position().x() > 1510.0) {
			this.velocity.setX(0.0);
			this.get_position().setX(1510.0);
		}




		// UPDATE PARENT OBJECT
		this.set_velocity( this.velocity );
		
		
		
		/*if(this.get_position().x() > 1510.0) {
			this.get_velocity().setY(this.get_velocity().x());
			this.get_velocity().setX(0.0);
			this.get_position().setX(1510.0);
			this.set_velocity(this.get_velocity().multiply(1.25));
		}else if(this.get_position().y() > 810.0) {
			this.get_velocity().setX(this.get_velocity().y() * -1.0);
			this.get_velocity().setY(0.0);
			this.get_position().setY(810.0);
			this.set_velocity(this.get_velocity().multiply(1.25));
		}else if(this.get_position().x() < 90.0) {
			this.get_velocity().setY(this.get_velocity().x());
			this.get_velocity().setX(0.0);
			this.get_position().setX(90.0);
			this.set_velocity(this.get_velocity().multiply(1.25));
		}else if(this.get_position().y() < 90.0) {
			this.get_velocity().setX(this.get_velocity().y() * -1.0);
			this.get_velocity().setY(0.0);
			this.get_position().setY(90.0);
			this.set_velocity(this.get_velocity().multiply(1.25));
		}*/
	}
}