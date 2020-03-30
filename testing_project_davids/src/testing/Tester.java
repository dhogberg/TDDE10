package testing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

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
	private Point bullet_pos;
	
	private BufferedImage spriteimage_bullet_enemy;
	private BufferedImage spriteimage_life_mushroom;

	public Tester(){
		position = new Point(0, 0);		
		bullet_pos = new Point(1000, 300);

		spriteimage_bullet_enemy	= loadImage("sprites/bullet_enemy_16x14.png");
		spriteimage_life_mushroom	= loadImage("sprites/life_mushroom_18x18.png");
	}

	public void delegate(Graphics g){
		if (g != null)
			draw(g);
		else
			update();
	}

	private void draw(Graphics g){
		if (position.x < SCREEN_WIDTH && position.y < SCREEN_HEIGHT) {
			testDraw(g);
		}
	}

	private void update(){
		
		/* ==== Used for testing ====*/
		
		position.x += 2;
		position.y += 2.11;
		
		bullet_pos.x += -10;
	}

	/* ====== USED FOR TESTING ====== */
	private void testDraw(Graphics g) {

		//g.setColor(Color.BLUE);
		//g.drawString("D-9", position.x + 20, position.y + 45);
		
		g.drawImage(spriteimage_life_mushroom, position.x + 200, position.y + 200, 30, 30, null);

		g.drawImage(spriteimage_bullet_enemy, bullet_pos.x + 50, bullet_pos.y + 50, 32, 28, null);
		
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
