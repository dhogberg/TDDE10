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
	private MyDrawArea layeredDrawArea;
	private Integer paintLayer_x;
	private DrawSettings drawSettings;

	public MyFrame() {
		super("Välkommen till Ritprogrammet!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		paintLayer_x = 0;

		// Add drawingarea
		layeredDrawArea = new MyDrawArea();
		layeredDrawArea.setLayout(null);
		layeredDrawArea.setVisible(true);
		layeredDrawArea.addMouseListener(this);

		// Add settings
		drawSettings = new DrawSettings();
		
		// Add bottompanel
		this.bottomPanel = new BottomPanel(layeredDrawArea);
		
		// Add sidepanel
		this.sidePanel = new SidePanel(drawSettings);
		
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(sidePanel, BorderLayout.EAST);
		this.add(layeredDrawArea, BorderLayout.CENTER);

		this.setVisible(true);
	}
	
	public DrawSettings drawSettings() {
		return this.drawSettings;
	}

	public JLayeredPane get_layeredDrawArea (){
		return this.layeredDrawArea;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.printf("CLICK! X=%s Y=%s\n", e.getX(), e.getY());
		
		Smiley smiley = new Smiley(e.getX() - 100, e.getY() - 100, 120234, 50, drawSettings.get_bg_color(), Color.BLACK);
		Circle circle = new Circle(e.getX(), e.getY(), 100, 100, drawSettings.get_bg_color(), Color.BLACK);
		Square square = new Square(e.getX(), e.getY(), 100, 100, drawSettings.get_bg_color(), Color.BLACK);
		Triangle triangle = new Triangle(e.getX(), e.getY(), 100, 100, drawSettings.get_bg_color(), Color.BLACK);
		
		//this.layeredDrawArea.add(smiley, paintLayer_x);
		
		switch(drawSettings.get_draw_component()) {
			case "square":
				this.layeredDrawArea.add(square, paintLayer_x);
				break;
			case "triangle":
				this.layeredDrawArea.add(triangle, paintLayer_x);
				break;
			case "smiley":
				this.layeredDrawArea.add(smiley, paintLayer_x);
				break;
			//  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
			default:
				this.layeredDrawArea.add(circle, paintLayer_x);
		}
		
		
		paintLayer_x = paintLayer_x + 1;
		
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