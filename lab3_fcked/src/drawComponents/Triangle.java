package drawComponents;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;
import javax.swing.JPanel;

public class Triangle extends DrawComponent {
	public Triangle(Integer x, Integer y, Integer w, Integer h, Color bg_color, Color stroke_color) {
		super(x, y, w, h, bg_color, stroke_color);
		this.setBounds(0, 0, 100000, 100000);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(get_bg_color());	
		Polygon triangle = new Polygon();
		triangle.addPoint(this.get_x() + this.get_w() / 2 - (this.get_w() / 2), this.get_y() - (this.get_h() / 2));
		triangle.addPoint(this.get_x() - (this.get_w() / 2), this.get_y() + this.get_h() - (this.get_h() / 2));
		triangle.addPoint(this.get_x() + this.get_w() - (this.get_w() / 2), this.get_y() + this.get_h() - (this.get_h() / 2));
		g.fillPolygon(triangle);
	}
}