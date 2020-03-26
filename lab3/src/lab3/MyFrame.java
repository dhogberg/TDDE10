package lab3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import drawComponents.*;

public class MyFrame extends JFrame implements MouseListener {
	private BottomPanel bottomPanel;
	private SidePanel sidePanel;
	private MyDrawArea myDrawArea;
	private JLayeredPane layeredDrawArea;
	private Integer testx;
	private DrawSettings drawSettings;

	public MyFrame() {
		super("Välkommen till Ritprogrammet!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Add drawingarea
		//myDrawArea = new MyDrawArea();

		
		// Add settings
		drawSettings = new DrawSettings();
		
		
		// TEST CODE
		layeredDrawArea = new JLayeredPane();
		
		layeredDrawArea.setLayout(null);
		layeredDrawArea.setPreferredSize(new Dimension(200,0));
		layeredDrawArea.setBackground(Color.blue);
		
		layeredDrawArea.addMouseListener(this);
		//layeredDrawArea.setBackground(Color.RED);
		layeredDrawArea.setVisible(true);
		
		layeredDrawArea.setBounds(0, 0, 100, 100);

		//myDrawArea.add(layeredDrawArea, BorderLayout.CENTER);
		
		testx = 0;
		
		
		//myDrawArea.addMouseListener(this);
		//myDrawArea.addMouseListener(this);
		
		// Add smiley
		
		
		////myDrawArea.setSize(500, 500);
		//myDrawArea.setLocationRelativeTo(null);
		//myDrawArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//////myDrawArea.setVisible(true);
		
		
		/////this.add(myDrawArea, BorderLayout.CENTER);// 
		this.add(layeredDrawArea, BorderLayout.CENTER);
		

		// Add bottompanel
		this.bottomPanel = new BottomPanel();
		this.add(bottomPanel, BorderLayout.SOUTH);

		// Add sidepanel
		this.sidePanel = new SidePanel(drawSettings);
		this.add(sidePanel, BorderLayout.EAST);
		
		this.setVisible(true);
	}
	
	public DrawSettings drawSettings() {
		return this.drawSettings;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.printf("CLICK! X=%s Y=%s\n", e.getX(), e.getY());
		
		Smiley smiley = new Smiley(e.getX() - 100, e.getY() - 100, 120234, 50, drawSettings.get_bg_color(), Color.BLACK);
		Circle circle = new Circle(e.getX(), e.getY(), 100, 100, drawSettings.get_bg_color(), Color.BLACK);
		Square square = new Square(e.getX(), e.getY(), 100, 100, drawSettings.get_bg_color(), Color.BLACK);
		Triangle triangle = new Triangle(e.getX(), e.getY(), 100, 100, drawSettings.get_bg_color(), Color.BLACK);
		
		//this.layeredDrawArea.add(smiley, testx);
		this.layeredDrawArea.add(triangle, testx);
		testx = testx + 1;
		
		this.layeredDrawArea.revalidate(); // --- // --- GÖR OM TILL EN REDRAW-FUNKTION!
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