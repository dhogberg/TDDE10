package lab3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;

import drawComponents.*;

public class SidePanel extends JPanel implements MouseListener {

	private JPanel colorPanel;
	private JPanel shapePanel;
	private SidePanelButton blackButton;
	private SidePanelButton whiteButton;
	private SidePanelButton blueButton;
	private SidePanelButton redButton;
	private SidePanelButton yellowButton;
	private SidePanelButton greenButton;
	private SidePanelButton magentaButton;
	private SidePanelButton cyanButton;

	private SidePanelButton circleButton;
	private SidePanelButton squareButton;
	private SidePanelButton triangleButton;
	
	private DrawSettings drawSettings;

	private ArrayList<SidePanelButton> buttons = new ArrayList<SidePanelButton>();

	public SidePanel(DrawSettings drawSettings) {

		this.drawSettings = drawSettings;
		
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(9,1));
		colorPanel.add(new JLabel("Färg"));
		//colorPanel.addMouseListener(this);

		blackButton = new SidePanelButton(Color.BLACK);
		whiteButton = new SidePanelButton(Color.WHITE);
		blueButton = new SidePanelButton(Color.BLUE);
		redButton = new SidePanelButton(Color.RED);
		yellowButton = new SidePanelButton(Color.YELLOW);
		greenButton = new SidePanelButton(Color.GREEN);
		magentaButton = new SidePanelButton(Color.MAGENTA);
		cyanButton = new SidePanelButton(Color.CYAN);

		blackButton.addMouseListener(this);
		whiteButton.addMouseListener(this);
		blueButton.addMouseListener(this);
		redButton.addMouseListener(this);
		yellowButton.addMouseListener(this);
		greenButton.addMouseListener(this);
		magentaButton.addMouseListener(this);
		cyanButton.addMouseListener(this);

		colorPanel.add(blackButton);
		colorPanel.add(whiteButton);
		colorPanel.add(blueButton);
		colorPanel.add(redButton);
		colorPanel.add(yellowButton);
		colorPanel.add(greenButton);
		colorPanel.add(magentaButton);
		colorPanel.add(cyanButton);

		JPanel shapePanel = new JPanel();
		shapePanel.setLayout(new GridLayout(4,1));
		shapePanel.add(new JLabel("Form"));
		
		circleButton = new SidePanelButton("circle");
		squareButton = new SidePanelButton("square");
		triangleButton = new SidePanelButton("triangle");

		shapePanel.add(circleButton);
		shapePanel.add(squareButton);
		shapePanel.add(triangleButton);
		
		//shapePanel.add(new JButton("REKTANGLE"));
		//shapePanel.add(new JButton("SQUARE"));
		//shapePanel.add(new JButton("TRIANGLE"));
		

		this.setLayout(new GridLayout(2, 1));
		this.setBackground(Color.GRAY);

		//JButton testButton1 = new JButton("btn1");
		//JButton testButton2 = new JButton("btn2");

		this.add(colorPanel);
		this.add(shapePanel);

		//this.add(testButton1, BorderLayout.NORTH);
		//this.add(testButton2, BorderLayout.NORTH);
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {
		blackButton.deselect();
		whiteButton.deselect();
		blueButton.deselect();
		redButton.deselect();
		yellowButton.deselect();
		greenButton.deselect();
		magentaButton.deselect();
		cyanButton.deselect();
		
		this.pressButton((SidePanelButton) e.getSource());
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void pressButton(SidePanelButton sidePanelButton) {
		drawSettings.set_bg_color(sidePanelButton.get_color());
		sidePanelButton.select();
	}
}