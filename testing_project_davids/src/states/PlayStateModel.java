package states;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import constants.Constants;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

import assets.PlayerObject;
import assets.BulletenemyObject;
import states.GameModel;

public class PlayStateModel {
	
	private PlayState playStateReference;
	private PlayerObject playerObject;
	private PlayerObject playerObject2;
	private BulletenemyObject bulletenemyObject;
	private Set<Integer> active_keys = new HashSet<Integer>();

	public PlayStateModel(PlayState playState) {
		this.playStateReference = playState;
		this.playerObject = new PlayerObject();
		this.playerObject2 = new PlayerObject();
		this.playerObject2.get_position().setX(1510.0);
		this.bulletenemyObject = new BulletenemyObject();
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		this.drawObjects(g2);
	}
	
	public void drawObjects(Graphics2D g2) {
		bulletenemyObject.draw(g2);
		playerObject.draw(g2);
		playerObject2.draw(g2);
	}
	
	public void update(double executionTime) {
		this.updateObjects(executionTime, this.active_keys);
	}
	
	public void updateObjects(double executionTime, Set<Integer> active_keys) {
		bulletenemyObject.update(executionTime);
		playerObject.update(executionTime, active_keys);
		playerObject2.update(executionTime, active_keys);
		System.out.printf("Active keys: %s\n",active_keys);
	}

	public void keyPressed(int keycode) {
		//System.out.printf("%s pressed!\n", keycode);
		active_keys.add(keycode);
	}

	public void keyReleased(int keycode) {
		//System.out.printf("%s released!\n", keycode);
		active_keys.remove(keycode);
	}

}







	/*
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

	
	//private void draw(Graphics g, Long startTime_ms){
	//	if (position.x < SCREEN_WIDTH && position.y < SCREEN_HEIGHT) {
	//		testDraw(g, startTime_ms);
	//	}
	//}

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


	private void update(double executionTime){
		//position.x += 2;
		//position.y += 2;
		
		//bullet_pos.x += -10;

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

	private BufferedImage loadImage(String imgPath) {
		try {
			return ImageIO.read(new File(imgPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	*/