package testing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import constants.Constants;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

import states.GameModel;

/**
 * This class is only used for testing that PlayState works as
 * intended.
 */
public class Tester {
	
	public class Point {
		int x;
		int y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	private Point position;
	private Point position2;
	private Point bullet_pos;
	
	private BufferedImage spriteimage_bullet_enemy;
	private BufferedImage spriteimage_life_mushroom;

	private GameModel model;

	public Tester(){
		position = new Point(0, 0);		
		bullet_pos = new Point(1000, 300);

		spriteimage_bullet_enemy	= loadImage("sprites/bullet_enemy_16x14.png");
		spriteimage_life_mushroom	= loadImage("sprites/life_mushroom_18x18.png");
	}

	public Tester(GameModel model){
		position = new Point(0, 0);
		
		position2 = new Point(-10, -10);
		bullet_pos = new Point(1000, 300);

		spriteimage_bullet_enemy	= loadImage("sprites/bullet_enemy_16x14.png");
		spriteimage_life_mushroom	= loadImage("sprites/life_mushroom_18x18.png");

		this.model = model;
	}

	public void delegate(Graphics g){
		if (g != null)
			draw(g);
		else
			update();
	}

	public void delegate2(Graphics g, Long startTime_ms){
		if (g != null)
			draw(g);
		else
			update(startTime_ms);
	}

	private void draw(Graphics g){
		if (position.x < SCREEN_WIDTH && position.y < SCREEN_HEIGHT) {
			testDraw(g);
		}
	}

	/*
	private void draw(Graphics g, Long startTime_ms){
		if (position.x < SCREEN_WIDTH && position.y < SCREEN_HEIGHT) {
			testDraw(g, startTime_ms);
		}
	}*/

	private void update(){
		
		//final long timer = System.nanoTime() - this.model.get_lastTime();
		
		//final double frameTimeFactor = timer / 10000000;
		//System.out.printf("Before: %s After: %s Delta: %s\n",this.model.get_lastTime(), afterTime, timer);
		
		position.x += 0.5 * 10 * 60 / Constants.FPS;
		position.y += 0.5 * 10 * 60 / Constants.FPS;
		
		//position2.x += 2 * frameTimeFactor;
		//position2.y += 2 * frameTimeFactor;
		
		position2.x += 0;
		position2.y += 0;
		
		//bullet_pos.x += -10 * frameTimeFactor;
		bullet_pos.x += -1 * 10 * 60 / Constants.FPS;
		
		//System.out.printf("WE GOT: %s\n",this.model.get_lastTime());
		// Calculate the time it took to update and render
	}

	private void update(Long startTime_ms){
		/*
		position.x += 2;
		position.y += 2;
		
		bullet_pos.x += -10;
		*/

		//System.out.printf("TESTER.JAVA GOT: %s\n",startTime_ms);
	}

	private void testDraw(Graphics g) {

		//g.setColor(Color.BLUE);
		//g.drawString("D-9", position.x + 20, position.y + 45);
		
		g.drawImage(spriteimage_life_mushroom, position.x + 15, position.y + 15, 30, 30, null);
		
		g.drawImage(spriteimage_life_mushroom, position2.x + 15, position2.y + 15, 30, 30, null);

		g.drawImage(spriteimage_bullet_enemy, bullet_pos.x + 16, bullet_pos.y + 14, 32, 28, null);
		g.drawImage(spriteimage_bullet_enemy, bullet_pos.x + 200, bullet_pos.y + 150, 32, 28, null);
		g.drawImage(spriteimage_bullet_enemy, bullet_pos.x + 10, bullet_pos.y + 370, 32, 28, null);
	}

	/* ====== USED FOR TESTING ======
	this is not a good way for loading more than one image.
	See the course web page for that information.
	*/
	private BufferedImage loadImage(String imgPath) {
		try {
			return ImageIO.read(new File(imgPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}