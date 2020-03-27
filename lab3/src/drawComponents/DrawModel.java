package drawComponents;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

public class DrawModel {

	private ArrayList<DrawComponent> drawComponents = new ArrayList<>();
	private Color bg_color;
	private String draw_component;
	
	public DrawModel() {
		this.draw_component = "circle";
		this.bg_color = Color.BLACK;
	}

	public ArrayList<DrawComponent> getDrawComponents() {
		return this.drawComponents;
	}
	
	public void addDrawComponent(Integer x, Integer y, Integer w, Integer h) {
		this.drawComponents.add(this.createDrawComponent(x, y, w, h));
	}
	
	public DrawComponent createDrawComponent(Integer x, Integer y, Integer w, Integer h) {
		switch(this.draw_component) {
			case "square":
				return (new Square(x, y, w, h, this.bg_color, this.bg_color));
			case "triangle":
				return (new Triangle(x, y, w, h, this.bg_color, this.bg_color));
			case "smiley":
				return (new Smiley(x - 100, y - 100, w, h, this.bg_color, this.bg_color));
			//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				return (new Circle(x, y, w, h, this.bg_color, this.bg_color));
		}
	}
	
	public Color get_bg_color() {
		return this.bg_color;
	}
	
	public void set_bg_color(Color bg_color) {
		this.bg_color = bg_color;
	}

	public void set_draw_component(String draw_component) {
		this.draw_component = draw_component;
	}

	public void clear() {
		this.drawComponents.clear();
	}

}