package states;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import codeassets.XYPoint;
import menu.MenuButton;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

/** 
 * 
 * This state represents the highscore menu of the game.
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class HighscoreState extends GameState{
	private String titel_text;
	private String menu;
	private MenuButton back_to_menu;
	private Color bgColor;
	private Color fontColor;
	
	public HighscoreState(GameModel model) {
		super(model);
		titel_text = "Highscores:";
		menu = "Menu";
		int startX = SCREEN_WIDTH-350;
		int startY = SCREEN_HEIGHT-250;
		back_to_menu = new MenuButton(menu, new XYPoint(startX,startY), new XYPoint(200,75));
		bgColor = new Color(91, 149, 254);
		fontColor = new Color(255, 255, 255);
	}
	
	public void mousePressed(MouseEvent e) {
		if(back_to_menu.containsXY(e.getX(), e.getY())) {
			System.out.println("changeState to Menustate");
			model.switchState(new MenuState(model));
		}
	}
	
	public void mousePressed(int x, int y) {
		if(back_to_menu.containsXY(x, y)) {
			System.out.println("changeState to Menustate");
			model.switchState(new MenuState(model));
		}
	}
	
	public ArrayList<Integer> get_highscores(){
		final ArrayList<Integer> arrlist;
		arrlist = new ArrayList<Integer>(model.get_highscores_object().get_highscores());
		return arrlist; 
	}

	public void draw_highscores(Graphics g) {		
		ArrayList<Integer> highscore = get_highscores();
		Collections.sort(highscore);
		Collections.reverse(highscore);
		int space = 50;
		for(int i = 0; i<highscore.size(); ++i) {
			g.drawString(Integer.toString(highscore.get(i)),SCREEN_WIDTH/2-200,250+space*i);
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