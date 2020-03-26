package lab3;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

import drawComponents.*;

public class MyDrawArea extends JLayeredPane {

	public MyDrawArea() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
	}

	public void clear() {
		this.removeAll();
		this.repaint();
	} 

	public void redraw() {
		this.revalidate();
	}

}