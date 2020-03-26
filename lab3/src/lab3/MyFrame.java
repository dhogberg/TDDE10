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
		//this.state.addObject(e.getX() - 25, e.getY() - 25, this.settings);
		//this.drawArea.repaint();
		System.out.printf("CLICK! X=%s Y=%s\n", e.getX(), e.getY());
		Smiley smiley = new Smiley(e.getX() - 100, e.getY() - 100, 120234, 50, drawSettings.get_bg_color(), Color.BLACK);
		
		//this.myDrawArea.add(smiley, BorderLayout.CENTER);
		this.layeredDrawArea.add(smiley, testx);
		testx = testx + 1;
		//this.myDrawArea.revalidate(); // --- // --- GÖR OM TILL EN REDRAW-FUNKTION!
		this.layeredDrawArea.revalidate(); // --- // --- GÖR OM TILL EN REDRAW-FUNKTION!
	}

	@Override
	public void mouseClicked(MouseEvent e) {}		

	@Override
	public void mouseExited(MouseEvent e) {}
}