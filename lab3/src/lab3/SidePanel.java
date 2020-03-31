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
	private DrawModel drawModel;
	
	private SidePanelButton blackButton, 
	whiteButton, blueButton, redButton,
	yellowButton, greenButton, magentaButton,
	cyanButton, circleButton, squareButton,
	triangleButton, smileyButton;
	
	private ArrayList<SidePanelButton_color> colorButtons;

	public SidePanel(DrawModel drawModel) {

		this.drawModel = drawModel;
		
		colorButtons = new ArrayList<SidePanelButton_color>();
		
		colorButtons.add(new SidePanelButton_color(Color.BLACK));
		colorButtons.add(new SidePanelButton_color(Color.WHITE));
		colorButtons.add(new SidePanelButton_color(Color.BLUE));
		colorButtons.add(new SidePanelButton_color(Color.RED));
		colorButtons.add(new SidePanelButton_color(Color.YELLOW));
		colorButtons.add(new SidePanelButton_color(Color.GREEN));
		colorButtons.add(new SidePanelButton_color(Color.MAGENTA));
		colorButtons.add(new SidePanelButton_color(Color.CYAN));
		
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(9,1));
		colorPanel.add(new JLabel("Färg"));

		for (SidePanelButton_color colorButton : colorButtons) { 		      
			colorButton.addMouseListener(this);
			colorPanel.add(colorButton);
		}
		
		JPanel shapePanel = new JPanel();
		shapePanel.setLayout(new GridLayout(5,1));
		shapePanel.setPreferredSize(new Dimension(100, 100));
		
		shapePanel.add(new JLabel("Form"));
		
		circleButton = new SidePanelButton_shape("circle");
		squareButton = new SidePanelButton_shape("square");
		triangleButton = new SidePanelButton_shape("triangle");
		smileyButton = new SidePanelButton_shape("smiley");

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

		setVisible(true);

		circleButton.select();
		colorButtons.get(0).select(); // Select black colorButton
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {
		if((e.getSource() instanceof SidePanelButton_color)){
			this.pressButton((SidePanelButton_color) e.getSource());
		}else if((e.getSource() instanceof SidePanelButton_shape)){
			this.pressButton((SidePanelButton_shape) e.getSource());
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void pressButton(SidePanelButton_color sidePanelButton_color) {
		this.drawModel.set_bg_color(sidePanelButton_color.get_color());
		
		for (SidePanelButton_color colorButton : colorButtons) { 		      
			colorButton.deselect();
		}
		
		sidePanelButton_color.select();
	}
	
	public void pressButton(SidePanelButton_shape sidePanelButton_shape) {
		this.drawModel.set_draw_component(sidePanelButton_shape.get_type_of_shape());
		circleButton.deselect();
		squareButton.deselect();
		triangleButton.deselect();
		smileyButton.deselect();
		sidePanelButton_shape.select();
	}
}