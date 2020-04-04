package gameobjects;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Color;

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
public class PlayfieldObject extends GameObject {

	private Color bgcolor;
	
	public PlayfieldObject() {
		super();
		this.set_scale(1.0);
		set_objectGraphic_width( PLAYFIELD_WIDTH );
		set_objectGraphic_height( PLAYFIELD_HEIGHT );
		this.set_position(PLAYFIELD_XPOS, PLAYFIELD_YPOS);
		this.updateHitbox();
		this.enableHitbox();
		this.bgcolor = new Color(100, 255, 100);
	}

	@Override
	public void drawObject(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor( bgcolor );
		g2.fillRect( this.get_position().x_as_int() , this.get_position().y_as_int() , this.get_width(), this.get_height());
	}
	
	public void set_bgcolor(Color color) {
		this.bgcolor = color;
	}
	@Override
	public boolean outsideDrawingArea() {
		return false;
	}
}