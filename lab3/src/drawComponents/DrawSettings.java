package drawComponents;

import java.awt.Color;

public class DrawSettings {

	private Color bg_color;
	private String draw_component;
	
	public DrawSettings() {
		bg_color = Color.BLACK;
		draw_component = "circle";
	}
	
	public Color get_bg_color() {
		return this.bg_color;
	}
	
	public void set_bg_color(Color color) {
		this.bg_color = color;
	}
	
	public String get_draw_component() {
		return this.draw_component;
	}
	
	public void set_draw_component(String draw_component) {
		this.draw_component = draw_component;
	}
	
}
