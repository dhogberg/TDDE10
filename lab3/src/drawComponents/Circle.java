package drawComponents;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Circle extends DrawComponent {

	public Circle(Integer x, Integer y, Integer w, Integer h, Color bg_color, Color stroke_color) {
		super(x, y, w, h, bg_color, stroke_color);
		this.setBounds(0, 0, 100000, 100000);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(get_bg_color());
		g.fillOval(this.get_x()-(this.get_w() / 2), this.get_y()-(this.get_h() / 2), this.get_w(), this.get_h());
	}

}