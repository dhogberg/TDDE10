package assets;

import assets.XYPoint;

import static constants.Constants.ACTIVEDRAWAREA_WIDTH;
import static constants.Constants.ACTIVEDRAWAREA_HEIGHT;
import static constants.Constants.ACTIVEDRAWAREA_XPOS;
import static constants.Constants.ACTIVEDRAWAREA_YPOS;

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class PlayerbulletObject extends GameObject {
	private XYPoint velocity;
	private PlayerObject player_reference;
	
	public PlayerbulletObject(PlayerObject player, int x, int y, double scale) {
		super();
		this.player_reference = player;
		load_objectGraphic_and_calc_dimensions("sprites/playerbullet_16x7.png");
		this.set_scale(1.5 * scale);
		
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
			case "bulletenemy" : case "shellenemy":
				this.disableHitbox();
				this.moveOutsideDrawArea();
				player_reference.add_score(10);
				System.out.println("PLAYERBULLET has collided with a ENEMYBULLET!");
				
				break;
			case "1up":
				break;
			// 
			default:
				System.out.println("PLAYERBULLET has collided with something!");
		}
	}

	@Override
	public void update(double executionTime) {
		super.update(executionTime);
	}
}