package lab3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SidePanel extends JPanel {

	private JPanel colorPanel;
	private JPanel shapePanel;
	private JPanel blackButton;
	private JPanel whiteButton;
	private JPanel blueButton;
	private JPanel redButton;
	private JPanel yellowButton;
	private JPanel greenButton;
	private JPanel magentaButton;
	private JPanel cyanButton;

	public SidePanel() {

		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(9,1));
		colorPanel.add(new JLabel("Färg"));

		blackButton = new JPanel();
		whiteButton = new JPanel();
		blueButton = new JPanel();
		redButton = new JPanel();
		yellowButton = new JPanel();
		greenButton = new JPanel();
		magentaButton = new JPanel();
		cyanButton = new JPanel();

		blackButton.setBackground(Color.BLACK);
		whiteButton.setBackground(Color.WHITE);
		blueButton.setBackground(Color.BLUE);
		redButton.setBackground(Color.RED);
		yellowButton.setBackground(Color.YELLOW);
		greenButton.setBackground(Color.GREEN);
		magentaButton.setBackground(Color.MAGENTA);
		cyanButton.setBackground(Color.CYAN);

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
		shapePanel.add(new JButton("REKTANGLE"));
		shapePanel.add(new JButton("SQUARE"));
		shapePanel.add(new JButton("TRIANGLE"));

		this.setLayout(new GridLayout(2, 1));
		this.setBackground(Color.GRAY);

		//JButton testButton1 = new JButton("btn1");
		//JButton testButton2 = new JButton("btn2");

		this.add(colorPanel);
		this.add(shapePanel);

		//this.add(testButton1, BorderLayout.NORTH);
		//this.add(testButton2, BorderLayout.NORTH);
	}

}