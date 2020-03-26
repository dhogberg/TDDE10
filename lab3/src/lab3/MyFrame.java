package lab3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {
	private BottomPanel bottomPanel;
	private SidePanel sidePanel;
	private MyDrawArea myDrawArea;

	public MyFrame() {
		super("Välkommen till Ritprogrammet!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Add drawingarea
		myDrawArea = new MyDrawArea();
		myDrawArea.addMouseListener(this);
		this.add(myDrawArea, BorderLayout.CENTER);

		// Add bottompanel
		this.bottomPanel = new BottomPanel();
		this.add(bottomPanel, BorderLayout.SOUTH);

		// Add sidepanel
		this.sidePanel = new SidePanel();
		this.add(sidePanel, BorderLayout.EAST);

		this.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("CLICK!");
	}

	@Override
	public void mouseClicked(MouseEvent e) {}		

	@Override
	public void mouseExited(MouseEvent e) {}
}