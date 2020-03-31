package lab3;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import drawComponents.Circle;
import drawComponents.Smiley;
import drawComponents.Square;
import drawComponents.Triangle;

public class SidePanelButton_shape extends SidePanelButton {

	private String type_of_shape;

	public SidePanelButton_shape(String type_of_shape) {
		super(type_of_shape);
		Circle circle = new Circle(13, 13, 26, 26, Color.BLACK, Color.BLACK);
		Circle circle2 = new Circle(13, 13, 26, 26, Color.YELLOW, Color.BLACK);
		Square square = new Square(13, 13, 26, 26, Color.BLACK, Color.BLACK);
		Triangle triangle = new Triangle(13, 13, 26, 26, Color.BLACK, Color.BLACK);
		this.type_of_shape = type_of_shape;
		switch(type_of_shape){
			case "square":
				this.add(square, BorderLayout.CENTER);
				break;
			case "triangle":
				
				this.add(triangle, BorderLayout.CENTER);
				break;
			case "smiley":
				this.add(circle2, BorderLayout.CENTER);
				break;
			//  //  //  //  //  //  //  //  //  //  //
			default: // circle
				//this.setBackground(Color.RED);
				this.add(circle, BorderLayout.CENTER);
		}
	}

	public void select() {
		this.setBorder(new LineBorder(Color.BLACK, 3));
	}

	public void deselect() {
		this.setBorder(null);
	}

	public String get_type_of_shape(){
		return this.type_of_shape;
	}
}