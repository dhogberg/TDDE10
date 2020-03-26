package lab3;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;

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
		this.type_of_shape = type_of_shape;
		switch(type_of_shape){
			case "square":
				Square square = new Square(0, 0, 10, 10, Color.BLACK, Color.BLACK);
				this.add(square, BorderLayout.CENTER);
				this.setBackground(Color.BLUE);
				break;
			case "triangle":
				Triangle triangle = new Triangle(0, 0, 26, 26, Color.BLACK, Color.BLACK);
				this.add(triangle);
				//this.setBackground(Color.GREEN);
				break;
			case "smiley":
				Smiley smiley = new Smiley(0, 0, 0, 0, Color.BLACK, Color.BLACK);
				this.add(smiley);
				//this.setBackground(Color.GREEN);
				break;
			//  //  //  //  //  //  //  //  //  //  //
			default: // circle
				//this.setBackground(Color.RED);
				Circle circle = new Circle(0, 0, 26, 26, Color.BLACK, Color.BLACK);
				this.add(circle);
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