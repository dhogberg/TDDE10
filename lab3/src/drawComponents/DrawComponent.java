package drawComponents;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class DrawComponent extends JComponent {

	private Integer x;
	private Integer y;
	private Integer w;
	private Integer h;
	private Color bg_color;
	private Color stroke_color;
	
	public DrawComponent(Integer x, Integer y, Integer w, Integer h, Color bg_color, Color stroke_color) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.bg_color = bg_color;
		this.stroke_color = stroke_color;
		//this.setBackground(Color.WHITE);
	}
	
	public abstract void paintComponent(Graphics g);

	public Integer get_x() {
		return this.x;
	}
	public Integer get_y() {
		return this.y;
	}
	public Integer get_w() {
		return this.w;
	}
	public Integer get_h() {
		return this.h;
	}
	public Color get_bg_color() {
		return this.bg_color;
	}
	public Color get_stroke_color() {
		return this.stroke_color;
	}
	public void set_x(Integer x) {
		this.x = x;
	}
	public void set_y(Integer y) {
		this.y = y;
	}
	public void set_w(Integer w) {
		this.w = w;
	}
	public void set_h(Integer h) {
		this.h = h;
	}
	public void set_bg_color(Color bg_color) {
		this.bg_color = bg_color;
	}
	public void set_stroke_color(Color stroke_color) {
		this.stroke_color = stroke_color;
	}
}