package drawComponents;

import java.util.ArrayList;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class DrawComponent extends JComponent {

	private Integer x;
	private Integer y;
	
	public DrawComponent(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	
}

public class DrawModel {

	private ArrayList<DrawComponent> drawComponents = new ArrayList<>();
	private String draw_component;
	
	public DrawModel() {
		
	}

	public ArrayList<DrawComponent> getDrawComponents() {
		return this.drawComponents;
	}
	
	public void addDrawComponent(Integer x, Integer y) {
		this.drawComponents.add(this.createDrawComponent(x, y));
	}
	
	public DrawComponent createDrawComponent(Integer x, Integer y) {
	
	}
	

	public void set_draw_component(String draw_component) {
		this.draw_component = draw_component;
	}

	public void clear() {
		this.drawComponents.clear();
	}

}