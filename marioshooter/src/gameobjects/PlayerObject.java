package gameobjects;

import java.awt.Graphics2D;
import java.util.Set;
import java.util.ArrayList;
import states.GameModel;
import states.GameoverState;
import codeassets.XYPoint;
import gameobjects.PlayerbulletObject;

import static constants.Constants.PLAYERLIFES;
import static constants.Constants.PLAYER_SHOOTINTERVAL;
import static constants.Constants.PLAYER_BLINKINTERVAL;
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
public class PlayerObject extends GameObject {
	private XYPoint velocity;
	private Boolean invisible;
	private Boolean blinking;
	private Boolean immortal;
	private Boolean shooting;
	private Boolean big;
	private double immortaltimer;
	private double bigtimer;
	private double blinkingtimer;
	private double blinkingintervaltimer;
	private double shoottimer;
	private double shootinterval;
	private int lifes;
	private int score;
	private double blinkinterval;
	private ArrayList<GameObject> gameobjects_reference;
	private GameModel model;

	public PlayerObject(ArrayList<GameObject> gameobjects, GameModel model) {
		super();
		this.model = model;
		this.gameobjects_reference = gameobjects;
		this.invisible = false;
		this.blinking = false;
		this.immortal = false;
		this.shooting = false;
		this.big = false;
		this.score = 0;
		this.lifes = PLAYERLIFES;
		this.blinkinterval = PLAYER_BLINKINTERVAL;
		this.shootinterval = PLAYER_SHOOTINTERVAL;
		load_objectGraphic_and_calc_dimensions("src/graphicassets/mariokart_28x30.png");
		this.set_scale(2.0);
		this.set_position(500.0, 450.0);
		this.velocity = new XYPoint(0.0, 0.0); this.set_velocity(this.velocity);
		this.updateHitbox();
		this.enableHitbox();
	}
	
	public int get_score() {
		return this.score;
	}
	
	public void add_score(int x) {
		this.score = this.score + x;
	}
	
	@Override
	public void collideWithGameobject(GameObject obj) {
		switch(obj.get_type_of_object()) {
			case "bulletenemy":
				obj.disableHitbox();
				this.collideWithBulletenemy();
				System.out.println("Player has collided with a bulletenemy!");
				break;
			case "1up":
				obj.disableHitbox();
				System.out.println("Player has collided with 1UP!");
				this.getaLife();
				break;
			case "mushroom":
				obj.disableHitbox();
				System.out.println("Player has collided with mushroom!");
				this.powerup_mushroom();
				break;
			case "starpowerup":
				obj.disableHitbox();
				System.out.println("Player has collided with starpower!");
				this.powerup_star();
			// 
			default:
				System.out.println("Player has collided with something!");
		}
	}
	
	public void collideWithBulletenemy() {
		if(!immortal) {
			this.loseLife();
			this.makeImmortalForSeconds(4.0);
			this.makeBlinkingForSeconds(4.0);
		}
	}

	public void powerup_star(){
		
	}
	
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
	
	public void loseGame() {
		model.get_highscores_object().save_score(this.score);
		model.set_lastScore(this.score);
		model.switchState(new GameoverState(model));
	}
	
	public void getaLife() {
		this.lifes = this.lifes + 1;
	}
	
	public void loseLife() {
		if(this.lifes > 1) {
			this.lifes = this.lifes - 1;
		}else {
			this.lifes = 0;
			this.loseGame();
		}
	}
	
	public void powerup_mushroom() {
		this.big = true;
		this.set_scale(this.get_scale() * 2);
		this.shootinterval = shootinterval / 2;
		this.bigtimer = 6.0;
	}
	
	public void updateBigTimer(double executionTime) {
		if(this.bigtimer < executionTime) {
			this.big = false;
			this.set_scale(this.get_scale() / 2);
			this.shootinterval = shootinterval * 2;
			this.bigtimer = 0.0;
		}else {
			this.bigtimer = this.bigtimer - executionTime;
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
	
	public void shoot() {
		this.shooting = true;
		if(shoottimer == 0.0){
			this.gameobjects_reference.add(new PlayerbulletObject(this, this.get_position().x_as_int() , this.get_position().y_as_int(), this.get_scale()));
			this.holdShootingForSeconds(this.shootinterval);
		}
	}

	public void holdShootingForSeconds(double seconds) {
		this.shoottimer = seconds;
	}
	
	public void updateShooting(double executionTime) {
		if(this.shooting) {
			if(executionTime < this.shoottimer) {
				this.shoottimer = this.shoottimer - executionTime;
			}else {
				this.shoottimer = 0.0;
				this.shooting = false;
			}
		}
	}
	
	public void update(double executionTime, Set<Integer> active_keys) {
		
		super.update(executionTime);
		
		if(this.immortal) {
			this.updateImmortalTimer(executionTime);
		}

		if(this.blinking){
			this.updateBlinking(executionTime);
		}
		
		if(this.shooting){
			this.updateShooting(executionTime);
		}
		
		if(this.big) {
			this.updateBigTimer(executionTime);
		}
		
		if(active_keys.contains(32)) { // SPACEBAR
			this.shoot();
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
			this.velocity.subtract(new XYPoint(3000.0 * executionTime, 0.0));
		}
		
		if(active_keys.contains(39)) { // KEYRIGHT	
			if(this.velocity.x() != 0.0) {
				if(this.velocity.x() < 0.0) {
					this.velocity.setX(0.0);
				}
			}
			this.velocity.add(new XYPoint(3000.0 * executionTime, 0.0));
		}
		
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
		if(this.get_position().y() > PLAYFIELD_YPOS + PLAYFIELD_HEIGHT - this.get_height() / 2) {
			this.velocity.setY(0.0);
			this.get_position().setY(PLAYFIELD_YPOS + PLAYFIELD_HEIGHT - this.get_height() / 2);
		}else if(this.get_position().y() < PLAYFIELD_YPOS + this.get_height() / 2) {
			this.velocity.setY(0.0);
			this.get_position().setY(PLAYFIELD_YPOS + this.get_height() / 2);
		}else if(this.get_position().x() < PLAYFIELD_XPOS + this.get_width() / 2) {
			this.velocity.setX(0.0);
			this.get_position().setX(PLAYFIELD_XPOS + this.get_width() / 2);
		}else if(this.get_position().x() > PLAYFIELD_XPOS + PLAYFIELD_WIDTH - this.get_width() / 2) {
			this.velocity.setX(0.0);
			this.get_position().setX(PLAYFIELD_XPOS + PLAYFIELD_WIDTH - this.get_width() / 2);
		}

		// UPDATE PARENT OBJECT
		this.set_velocity( this.velocity );
	}
}