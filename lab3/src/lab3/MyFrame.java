package lab3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import drawComponents.*;

public class MyFrame extends JFrame implements MouseListener {
	private BottomPanel bottomPanel;
	private SidePanel sidePanel;
	private MyDrawArea myDrawArea;
	private DrawModel drawModel = new DrawModel();

	public MyFrame() {
		super("Välkommen till Ritprogrammet!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Add drawingarea
		myDrawArea = new MyDrawArea(drawModel);
		myDrawArea.setLayout(null);
		myDrawArea.setVisible(true);
		myDrawArea.addMouseListener(this);
		
		// Add bottompanel
		this.bottomPanel = new BottomPanel(myDrawArea, drawModel);

		// Add sidepanel
		this.sidePanel = new SidePanel(drawModel);
		
		// Add everything to the frame
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(sidePanel, BorderLayout.EAST);
		this.add(myDrawArea, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public MyDrawArea get_myDrawArea (){
		return this.myDrawArea;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// DEBUG > > > System.out.printf("CLICK! X=%s Y=%s\n", e.getX(), e.getY());
		drawModel.addDrawComponent(e.getX(), e.getY(), 100, 100);
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