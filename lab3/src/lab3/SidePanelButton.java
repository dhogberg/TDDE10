package lab3;

import java.awt.Color;
import javax.swing.JPanel;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SidePanelButton extends JPanel {

	private Color color;
	private String type_of_shape;
	
	public SidePanelButton(Color color) {
		this.setBackground(color);
		this.color = color;
	}

	public SidePanelButton(String type_of_shape) {
		this.type_of_shape = type_of_shape;
		switch(type_of_shape){
			case "square":
				this.setBackground(Color.BLUE);
				break;
			case "triangle":
				this.setBackground(Color.GREEN);
				break;
			//  //  //  //  //  //  //  //  //  //  //
			default: // circle
				this.setBackground(Color.RED);
		}
		
	}
	
	public String get_type_of_shape(){
		return this.type_of_shape;
	}

	public Color get_color() {
		return this.color;
	}

	public void select() {
		if(this.color == Color.BLACK) {
			this.setBorder(new LineBorder(Color.WHITE, 3));
		}else {
			this.setBorder(new LineBorder(Color.BLACK, 3));
		}
	}

	public void deselect() {
		this.setBorder(null);
	}
	
}