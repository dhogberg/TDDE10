package menu;

import javax.swing.JPanel;
import assets.XYPoint;

public class MenuButton extends JPanel{
	
	private XYPoint position;
	private String text;
	private int width;
	private int height;
	
	//private Jpanel Menubotton;
	
	public MenuButton(String text, XYPoint position, XYPoint dimensions) {
		this.position = position;
		this.width = dimensions.x_as_int();
		this.height = dimensions.y_as_int();
	}
	
	public int get_x(){
		return this.position.;
	}
	
	public int get_y(){
		return this.height;
	}
	
	public int get_width(){
		return this.width;
	}
	
	public int get_height(){
		return this.height;
	}
	
	public String get_text(){
		return this.text;
	}
}
