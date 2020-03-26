package drawComponents;

import java.awt.Color;

public class DrawSettings {

	private Color bg_color;
	
	public DrawSettings() {
		bg_color = Color.BLACK;
	}
	
	public Color get_bg_color() {
		return this.bg_color;
	}
	
	public void set_bg_color(Color color) {
		this.bg_color = color;
	}
	
}
