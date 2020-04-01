package assets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import assets.XYPoint;

import static constants.Constants.SIDEBAR_WIDTH;
import static constants.Constants.SIDEBAR_HEIGHT;
import static constants.Constants.SIDEBAR_XPOS;
import static constants.Constants.SIDEBAR_YPOS;

public class SidebarObject extends GameObject {

	public SidebarObject() {
		super();
		
		this.set_scale(1.0);
		set_objectGraphic_width(SIDEBAR_WIDTH);
		set_objectGraphic_height(SIDEBAR_HEIGHT);
		
		this.set_position(SIDEBAR_XPOS, SIDEBAR_YPOS);
		//this.updateHitbox();
		//this.enableHitbox();
	}

	@Override
	public void drawObject(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(new Color(200, 200, 200));
		g2.fillRect( this.get_position().x_as_int() , this.get_position().y_as_int() , this.get_width(), this.get_height());
	}
	
	
	public boolean outsideDrawingArea() {
		return false;
	}
	
	/*
	@Override
	public void update(double executionTime) {
		super.update(executionTime);

		// Here we can add specifics to the playfield
	}
	*/
}