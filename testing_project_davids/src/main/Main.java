package main;

import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import constants.Constants;
import states.GameModel;

// TEMP ! ! ! ! NEEDED WORKAROUND TO SKIP MENU AND PROCEED IMMEDIATELY TO THE RUNNING GAME
import states.*;

public class Main {
	public static void main(String[] args) {		
		GameModel model = new GameModel();
		GameFrame frame = new GameFrame("MarioShooter", model);
		
		// TEMP ! ! ! ! SKIP MENU AND PROCEED IMMEDIATELY TO RUNNING GAME
		//model.switchState(new PlayState(model));
		
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
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}