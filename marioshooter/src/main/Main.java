package main;

import java.awt.Toolkit;
import constants.Constants;
import states.GameModel;

/** 
 * 
 * 
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class Main {
	public static void main(String[] args) {		
		GameModel model = new GameModel();
		GameFrame frame = new GameFrame("MarioShooter", model);
		
		double ms = 1000.0 / Constants.FPS;
		while (true) {
			long lastTime = System.currentTimeMillis();
			model.update();
			frame.repaint();
			long timer = System.currentTimeMillis() - lastTime;
			Toolkit.getDefaultToolkit().sync();
			try {
				Thread.sleep((long) Math.max(ms - timer, 0));
			} catch (InterruptedException e) {}
		}
	}
}