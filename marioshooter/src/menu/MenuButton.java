package menu;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;


import assets.XYPoint;

/** 
 * 
 * TODO: Represents the menu button. Draws the menu botton and its size/hitbox
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class MenuButton extends JPanel{
	
	private XYPoint position;
	private XYPoint dimensions;
	private String text;
	
	
	
	public MenuButton(String text, XYPoint position, XYPoint dimensions) {
		this.position = position;
		this.dimensions = dimensions;
		this.text = text;
	}
	
	public void draw (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(255, 0, 0));
		g2.fillRect(this.position.x_as_int() - this.dimensions.x_as_int() / 2, this.position.y_as_int() - this.dimensions.y_as_int() / 2, this.dimensions.x_as_int(), this.dimensions.y_as_int());
		g2.setColor(new Color(255, 255, 255));
		g2.drawString(this.text, this.position.x_as_int()-((stringSize(this.text)*15)), this.position.y_as_int()+30);
		g2.setColor(new Color(0, 255, 0));
	}
	
	int stringSize(String str) {
		return str.length();
	}
	
	public int get_x(){
		return this.position.x_as_int();
	}
	
	public int get_y(){
		return this.position.y_as_int();
	}
	
	public int get_width(){
		return this.dimensions.x_as_int();
	}
	
	public int get_height(){
		return this.dimensions.y_as_int();
	}
	
	public String get_text(){
		return this.text;
	}

	public boolean containsXY(int x, int y){
	
		final int x1 =  (get_x())-(get_width()/2);
		final int y1 = (get_y()) - (get_height()/2);
		final int x2 =  (get_x())+(get_width()/2);
		final int y2 = (get_y()) + (get_height()/2);
		if(x>x1 && x<x2 && y>y1 && y<y2) {
			return true;
		}
		
		else {
			return false;
		}
		
		/*this.position
		this.height
		this.width*/
		
		}
	}

