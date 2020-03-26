package lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLayeredPane;

import javax.swing.JPanel;

import drawComponents.Circle;
import drawComponents.Smiley;
import drawComponents.Square;
import drawComponents.Triangle;

import javax.swing.JButton;

public class BottomPanel extends JPanel implements MouseListener {
	private JLayeredPane layeredDrawArea;

	public BottomPanel(JLayeredPane layeredDrawArea) {
		this.layeredDrawArea = layeredDrawArea;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		JButton clearButton = new JButton("Rensa");
		clearButton.addMouseListener(this);
		this.add(clearButton, BorderLayout.WEST);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		layeredDrawArea.removeAll();
		layeredDrawArea.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}		

	@Override
	public void mouseExited(MouseEvent e) {}
}