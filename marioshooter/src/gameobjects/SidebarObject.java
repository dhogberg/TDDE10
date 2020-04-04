package gameobjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

import codeassets.XYPoint;
import levels.GameLevels;

import static constants.Constants.SIDEBAR_WIDTH;
import static constants.Constants.SIDEBAR_HEIGHT;
import static constants.Constants.SIDEBAR_XPOS;
import static constants.Constants.SIDEBAR_YPOS;

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class SidebarObject extends GameObject {

	private PlayerObject playerobject_reference;
	private GameLevels lvl_reference;
	
	public SidebarObject(PlayerObject player, GameLevels currentlevel) {
		super();
		this.playerobject_reference = player;
		this.lvl_reference = currentlevel;
		this.set_scale(1.0);
		set_objectGraphic_width(SIDEBAR_WIDTH);
		set_objectGraphic_height(SIDEBAR_HEIGHT);
		this.set_position(SIDEBAR_XPOS, SIDEBAR_YPOS);
	}

	@Override
	public void drawObject(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(new Color(255, 255, 255));
		g2.fillRect( this.get_position().x_as_int() , this.get_position().y_as_int() , this.get_width(), this.get_height());
		
		
		g2.setColor(new Color(0,0,0));
		g2.setFont(new Font("Monospace", Font.PLAIN, 30));
		final int line_height = 24;
		final int line_spacing = 10;
		final int paragraph_spacing = 50;
		
		final int all_text_x_pos = this.get_position().x_as_int() + 100;
		
		final int y_pos_score = this.get_position().y_as_int() + line_height + 50;
		
		// PRINT SCORE
		g2.drawString("Score:", all_text_x_pos , y_pos_score);
		g2.drawString(Integer.toString(playerobject_reference.get_score()), all_text_x_pos , y_pos_score + line_height + line_spacing );
		
		final int y_pos_highscore = y_pos_score + line_height + line_spacing + line_height + paragraph_spacing;
		
		// PRINT HIGHSCORE
		g2.drawString("Highscore:", all_text_x_pos , y_pos_highscore);
		g2.drawString("1337000", all_text_x_pos , y_pos_highscore + line_height + line_spacing );
		
		final int y_pos_level = y_pos_highscore + line_height + line_spacing + line_height + paragraph_spacing;
		
		// PRINT LEVEL
		g2.drawString("Level " + lvl_reference.getLevel() , all_text_x_pos , y_pos_level);
		
		
		final int y_pos_lives = y_pos_level + line_height + paragraph_spacing;
		
		// PRINT LIVES
		g2.drawString("Lives", all_text_x_pos , y_pos_lives);
		g2.drawString(Integer.toString(playerobject_reference.get_lifes()), all_text_x_pos , y_pos_lives + line_height + line_spacing);
	}
	
	@Override
	public boolean outsideDrawingArea() {
		return false;
	}
}