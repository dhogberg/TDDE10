package lab3;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

import drawComponents.*;

public class MyDrawArea extends JPanel {
	
	private Graphics g;
	private DrawModel drawModel;

	public MyDrawArea(DrawModel drawModel) {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.drawModel = drawModel;
	}

	public void paintComponent() {
		this.paintComponent(g);
	}
	
	public void paintComponent(Graphics g) {
		for (DrawComponent drawComponent : this.drawModel.getDrawComponents()) {
			drawComponent.paintComponent(g);
		}
		this.repaint();
	}
}