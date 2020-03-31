package assets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Set;
import main.Main;
import assets.XYPoint;

import static constants.Constants.PLAYERLIFES;
import static constants.Constants.PLAYER_BLINKINTERVAL;

public class PlayerObject extends GameObject {

	private BufferedImage objectGraphic;
	private XYPoint position;
	private XYPoint velocity;
	private Boolean invisible;
	private Boolean blinking;
	private Boolean immortal;
	private double immortaltimer;
	private double invisibletimer;
	private double blinkingtimer;
	private double blinkingintervaltimer;
	private int lifes;
	private double blinkinterval;
	
	public PlayerObject() {
		super();
		
		this.invisible = false;
		this.blinking = false;
		this.immortal = false;
		
		this.lifes = PLAYERLIFES;
		this.blinkinterval = PLAYER_BLINKINTERVAL;
		
		this.objectGraphic = Main.loadImage("sprites/player_tmp_18x18.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(5.0);
		set_objectGraphic_width(18);
		set_objectGraphic_height(18);
		this.set_position(90.0, 90.0);
		this.velocity = new XYPoint(0.0, 0.0); this.set_velocity(this.velocity);
		this.updateHitbox();
		this.enableHitbox();
	}
	
	public void collideWithBulletenemy() {
		if(!immortal) {
			this.loseLife();
			this.makeImmortalForSeconds(4.0);
			this.makeBlinkingForSeconds(4.0);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//FOR DEV
	public int get_lifes() {
		return this.lifes;
	}
	
	public boolean get_invisible() {
		return this.invisible;
	}
	
	public boolean get_immortal() {
		return this.immortal;
	}

	public boolean get_blinking() {
		return this.invisible;
	}
	
	public double get_immortaltimer() {
		return this.immortaltimer;
	}

	public double get_blinkingintervaltimer() {
		return this.blinkingintervaltimer;
	}
	//FOR DEV
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	
	public void loseLife() {
		if(this.lifes > 1) {
			this.lifes = this.lifes - 1;
		}else {
			// TODO: GAME OVER!
			this.lifes = 0;
			System.out.println("Game over! You are out of lifes");
		}
	}
	
	public void makeBlinkingForSeconds(double seconds) {
		this.blinking = true;
		this.blinkingtimer = seconds;
		this.blinkingintervaltimer = this.blinkinterval;
	}

	public void makeImmortalForSeconds(double seconds) {
		this.immortal = true;
		this.immortaltimer = seconds;
	}
	
	public void updateImmortalTimer(double executionTime) {
		if(executionTime < this.immortaltimer) {
			this.immortaltimer = this.immortaltimer - executionTime;
		}else {
			this.immortaltimer = 0.0;
			this.immortal = false;
		}
	}

	public void updateBlinking(double executionTime){
		this.updateBlinkingTimer(executionTime);
		if(this.blinking) {
			if(executionTime < this.blinkingintervaltimer) {
				this.blinkingintervaltimer = this.blinkingintervaltimer - executionTime;
			}else {
				this.blinkingintervaltimer = this.blinkinterval;
				if(this.invisible){
					this.invisible = false;
				}else{
					this.invisible = true;	
				}
			}
		}else {
			this.invisible = false;
			this.blinkingintervaltimer = 0.0;
		}
	}

	public void updateBlinkingTimer(double executionTime) {
		if(executionTime < this.blinkingtimer) {
			this.blinkingtimer = this.blinkingtimer - executionTime;
		}else {
			this.blinkingtimer = 0.0;
			this.blinking = false;
			this.invisible = true;
		}
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
	
	@Override
	public void draw(Graphics2D g2d) {
		if(!this.invisible) {
			super.drawObject(g2d);
		}
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
		
		if(this.immortal) {
			this.updateImmortalTimer(executionTime);
		}

		if(this.blinking){
			this.updateBlinking(executionTime);
		}
		
		
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
		if(this.velocity.x() != 0.0) {
			if(this.velocity.x() < 0.0) {
				if(makePos(this.velocity.x()) < (subtraction_constant * executionTime)) {
					this.velocity.setX(0.0);
				}else {
					this.velocity.setX( this.velocity.x() + subtraction_constant * executionTime );
				}
			}else if(this.velocity.x() > 0.0){
				
				if(makePos(this.velocity.x()) < (subtraction_constant * executionTime)) {
					this.velocity.setX(0.0);
				}else {
					this.velocity.setX( this.velocity.x() - subtraction_constant * executionTime );
				}	
			}	
		}
		
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