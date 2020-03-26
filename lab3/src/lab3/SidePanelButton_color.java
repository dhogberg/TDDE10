package lab3;

import java.awt.Color;
import javax.swing.JPanel;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SidePanelButton_color extends SidePanelButton {

	private Color color;
	
	public SidePanelButton_color(Color color) {
		super(color);
		this.setBackground(color);
		this.color = color;
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