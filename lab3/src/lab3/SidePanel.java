package lab3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

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
	private SidePanelButton smileyButton;
	
	private DrawSettings drawSettings;

	public SidePanel(DrawSettings drawSettings) {

		this.drawSettings = drawSettings;
		
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(9,1));
		colorPanel.add(new JLabel("Färg"));
		//colorPanel.addMouseListener(this);

		blackButton = new SidePanelButton_color(Color.BLACK);
		whiteButton = new SidePanelButton_color(Color.WHITE);
		blueButton = new SidePanelButton_color(Color.BLUE);
		redButton = new SidePanelButton_color(Color.RED);
		yellowButton = new SidePanelButton_color(Color.YELLOW);
		greenButton = new SidePanelButton_color(Color.GREEN);
		magentaButton = new SidePanelButton_color(Color.MAGENTA);
		cyanButton = new SidePanelButton_color(Color.CYAN);

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
		shapePanel.setLayout(new GridLayout(5,1));
		shapePanel.setPreferredSize(new Dimension(100, 100));
		
		shapePanel.add(new JLabel("Form"));
		
		circleButton = new SidePanelButton_shape("circle");
		squareButton = new SidePanelButton_shape("square");
		triangleButton = new SidePanelButton_shape("triangle");
		smileyButton = new SidePanelButton_shape("smiley");
		
        setVisible(true);
 

		circleButton.addMouseListener(this);
		squareButton.addMouseListener(this);
		triangleButton.addMouseListener(this);
		smileyButton.addMouseListener(this);
		
		shapePanel.add(circleButton);
		shapePanel.add(squareButton);
		shapePanel.add(triangleButton);
		shapePanel.add(smileyButton);		

		this.setLayout(new GridLayout(2, 1));
		this.setBackground(Color.GRAY);

		this.add(colorPanel);
		this.add(shapePanel);
		
		circleButton.select();
		blackButton.select();
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {
		if((e.getSource() instanceof SidePanelButton_color)){
			System.out.print("INSTANCE OF SIDEPANELBTN COLOR WORKS! 1111\n");
			this.pressButton((SidePanelButton_color) e.getSource());
		}else if((e.getSource() instanceof SidePanelButton_shape)){
			System.out.print("INSTANCE OF SIDEPANELBTN SHAPE WORKS! 2222\n");
			this.pressButton((SidePanelButton_shape) e.getSource());
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void pressButton(SidePanelButton_color sidePanelButton_color) {
		drawSettings.set_bg_color(sidePanelButton_color.get_color());
		blackButton.deselect();
		whiteButton.deselect();
		blueButton.deselect();
		redButton.deselect();
		yellowButton.deselect();
		greenButton.deselect();
		magentaButton.deselect();
		cyanButton.deselect();
		sidePanelButton_color.select();
	}
	
	public void pressButton(SidePanelButton_shape sidePanelButton_shape) {
		drawSettings.set_draw_component(sidePanelButton_shape.get_type_of_shape());
		circleButton.deselect();
		squareButton.deselect();
		triangleButton.deselect();
		smileyButton.deselect();
		sidePanelButton_shape.select();
	}
}