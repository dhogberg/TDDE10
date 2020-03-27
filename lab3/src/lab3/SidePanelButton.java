package lab3;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public abstract class SidePanelButton extends JPanel {
	public SidePanelButton(Color color) {}
	public SidePanelButton(String type_of_shape) {}
	public abstract void select();
	public abstract void deselect();
}