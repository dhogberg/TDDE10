package lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;

public class BottomPanel extends JPanel {
	public BottomPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		JButton clearButton = new JButton("Rensa");
		this.add(clearButton, BorderLayout.WEST);
	}
}