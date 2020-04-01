package states;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*; 

import menu.MenuButton;
import assets.XYPoint;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

/**
 * This state represents the menu of the Game
 * The main responsibility of this class is to allow
 * the user to swap state to the PlayState
 */

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class HighscoreState extends GameState{
	
	private String titel_text;
	private String startgame_text;
	private String highscores_text;
	private String quit_text;
	private String menu;
	
	private MenuButton back_to_menu;
	

	private Color bgColor;
	private Color fontColor;

	/**
	 * The following three variables are just used to show that a
	 * change of state can be made. The same variables also exist
	 * in the PlayState, can you think of a way to make this more
	 * general and not duplicate variables?????
	 */


	
	public HighscoreState(GameModel model) {
		super(model);
		
		
		titel_text = "Highscores:";
		String test = Integer.toString(SCREEN_WIDTH); //1600
		String test2 = Integer.toString(SCREEN_HEIGHT); //900
				
		startgame_text = "1";
		highscores_text = "2";
		quit_text = "3";
		menu = "Menu";
		
		int startX = SCREEN_WIDTH-350;
		int startY = SCREEN_HEIGHT-250;
		
		back_to_menu = new MenuButton(menu, new XYPoint(startX,startY), new XYPoint(200,75));
		
		
		
		bgColor = new Color(91, 149, 254);
		fontColor = new Color(255, 255, 255);
		
		//model.switchState(new PlayState(model));
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if(back_to_menu.containsXY(e.getX(), e.getY())) {
			System.out.println("changeState to Menustate");
			model.switchState(new MenuState(model));
		}
		
	}
	
	
	public ArrayList<Integer> get_highscores(){
		final ArrayList<Integer> arrlist;
		
		arrlist = new ArrayList<Integer>();
		
		arrlist.add(1337);
		arrlist.add(242);
		arrlist.add(22);
		arrlist.add(20);
		
		arrlist.add(500);
		arrlist.add(13);
		arrlist.add(73);
		
		arrlist.add(2);
		arrlist.add(7);
		arrlist.add(6);
		arrlist.add(9);
		
		return arrlist; 
	}

	
	public void draw_highscores(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		final ArrayList<Integer> tmp_scores; 
		ArrayList<Integer> highscore = get_highscores();
		Collections.sort(highscore);
		Collections.reverse(highscore);
		int space = 50;
		if(highscore.size() == 0) {
			g.drawString("0", SCREEN_WIDTH/2-200,250+space);
		}
		else {
		for(int i = 0; i<10; ++i) {
			g.drawString(Integer.toString(highscore.get(i)),SCREEN_WIDTH/2-200,250+space*i);
		}
		}
		g.setColor(fontColor);
		g.setFont(new Font("Monospace", Font.PLAIN, 60));
		
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		drawBg(g, bgColor);

		g.setColor(fontColor);
		g.setFont(new Font("Monospace", Font.PLAIN, 60));
		g.drawString(titel_text, (SCREEN_WIDTH / 2) - 400, SCREEN_HEIGHT / 5 );
		
		this.draw_highscores(g);
		back_to_menu.draw(g2);
	}
	
	
	public void keyPressed(int key) {
		// TODO: Add keyboard functionality
	}
	public void keyReleased(int key) {
		// TODO: Add keyboard functionality
	}
	
	@Override
	public void update() { }
	
}