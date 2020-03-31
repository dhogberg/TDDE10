package assets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import assets.XYPoint;

import static constants.Constants.PLAYFIELD_WIDTH;
import static constants.Constants.PLAYFIELD_HEIGHT;
import static constants.Constants.PLAYFIELD_XPOS;
import static constants.Constants.PLAYFIELD_YPOS;

public class PlayfieldObject extends GameObject {

	public PlayfieldObject() {
		super();
		
		this.set_scale(1.0);
		set_objectGraphic_width( PLAYFIELD_WIDTH );
		set_objectGraphic_height( PLAYFIELD_HEIGHT );
		
		this.set_position(PLAYFIELD_XPOS, PLAYFIELD_YPOS);
		this.updateHitbox();
		this.enableHitbox();
	}

	@Override
	public void drawObject(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(new Color(100, 255, 100));
		g2.fillRect( this.get_position().x_as_int() , this.get_position().y_as_int() , this.get_width(), this.get_height());
	}
	
	/*
	@Override
	public void update(double executionTime) {
		super.update(executionTime);

		// Here we can add specifics to the playfield
	}
	*/
}