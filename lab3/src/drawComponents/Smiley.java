package drawComponents;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Smiley extends DrawComponent {
	public Smiley(Integer x, Integer y, Integer w, Integer h, Color bg_color, Color stroke_color) {
		super(x, y, w, h, bg_color, stroke_color);
		//this.setBounds(x, y, 200, 200);
		this.setBounds(0, 0, 100000, 100000);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		g.setColor(get_bg_color());
		g.fillOval(this.get_x()+10, this.get_y()+10, 200, 200);
		// draw Eyes
		g.setColor(Color.BLACK);
		g.fillOval(this.get_x()+55, this.get_y()+65, 30, 30);
		g.fillOval(this.get_x()+135, this.get_y()+65, 30, 30);
		// draw Mouth
		g.fillOval(this.get_x()+50, this.get_y()+110, 120, 60);
		// adding smile
		g.setColor(get_bg_color());
		g.fillRect(this.get_x()+50, this.get_y()+110, 120, 30);
		g.fillOval(this.get_x()+50, this.get_y()+120, 120, 40);
	}
}