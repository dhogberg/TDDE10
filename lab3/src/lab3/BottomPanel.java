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

import drawComponents.*;

public class BottomPanel extends JPanel implements MouseListener {
	private MyDrawArea layeredDrawArea;
	private DrawModel drawModel;

	public BottomPanel(MyDrawArea layeredDrawArea, DrawModel drawModel) {
		this.layeredDrawArea = layeredDrawArea;
		this.drawModel = drawModel;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		JButton clearButton = new JButton("Rensa");
		clearButton.addMouseListener(this);
		this.add(clearButton, BorderLayout.WEST);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		drawModel.clear();
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