package states;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

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
public class HighscoreState extends GameState{
	
	private String titel_text;
	private String startgame_text;
	private String highscores_text;
	private String quit_text;
	
	private MenuButton startgame_text_2;
	private MenuButton highscores_text_2;
	private MenuButton quit_text_2;

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
		
		int startX = SCREEN_WIDTH/2;
		int startY = SCREEN_HEIGHT/3;
		int space = 100;
		
		startgame_text_2 = new MenuButton(startgame_text, new XYPoint(startX,startY), new XYPoint(350,75));
		highscores_text_2 = new MenuButton(highscores_text, new XYPoint(startX,startY+(space)), new XYPoint(350,75));
		quit_text_2 = new MenuButton(quit_text, new XYPoint(startX,startY+(space*2)), new XYPoint(350,75));
		
		
		bgColor = new Color(91, 149, 254);
		fontColor = new Color(255, 255, 255);
		
		//model.switchState(new PlayState(model));
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if(startgame_text_2.containsXY(e.getX(), e.getY())) {
			System.out.println("changeState to PlayState");
			model.switchState(new PlayState(model));
		}
		if(highscores_text_2.containsXY(e.getX(), e.getY())) {
			System.out.println("changeState to HighscoreState");
		}
	}
	
	
	public ArrayList<Integer> get_highscores(){
		final ArrayList<Integer> arrlist;
		
		arrlist = new ArrayList<Integer>();
		
		arrlist.add(1337);
		arrlist.add(242);
		arrlist.add(22);
		arrlist.add(20);
		arrlist.add(19);
		arrlist.add(17);
		//arrlist.add(15);
		//arrlist.add(13);
		//arrlist.add(10);
		
		return arrlist; 
	}

	
	public void draw_highscores(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		final ArrayList<Integer> tmp_scores; 
		
		tmp_scores = new ArrayList<Integer>(get_highscores());
	
		g.setColor(fontColor);
		g.setFont(new Font("Monospace", Font.PLAIN, 60));
		g.drawString("TEST !!", 250, 250);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		drawBg(g, bgColor);

		g.setColor(fontColor);
		g.setFont(new Font("Monospace", Font.PLAIN, 60));
		g.drawString(titel_text, (SCREEN_WIDTH / 2) - 400, SCREEN_HEIGHT / 5 );
		
		/*
		ArrayList<int> testarray = new ArrayList<int>;
		
		testarray = new ArrayList<int>;
		*/
		// Print highscores
		
		//for(ArrayList<int> x : )
		
		this.draw_highscores(g);
		
		
		startgame_text_2.draw(g2);
		highscores_text_2.draw(g2);
		quit_text_2.draw(g2);

	}
	
	
	public void keyPressed(int key) {
		// TODO: Add keyboard functionality
	}
	public void keyReleased(int key) {
		// TODO: Add keyboard functionality
	}
	
	public void startPressed(MouseEvent e) {
		//if(e.getX()>=800 && e.getX()<= 800+350) {
			System.out.println("d�");
		//}
	}
	
	
	// // // // // // // // // // // // // // // // // // // // // // // // // // // //
	// // // // // // // // // // // // // // // // // // // // // // // // // // // //
	//@Override
	//public void keyPressed(int key) {
	//	System.out.println("Trycker på " + KeyEvent.getKeyText(key) + " i MenuState");
	//
	//	if (key == KeyEvent.VK_ENTER)
	//		model.switchState(new PlayState(model));
	//	if (key == KeyEvent.VK_ESCAPE)
	//		System.exit(0);
	//}
	// // // // // // // // // // // // // // // // // // // // // // // // // // // //
	// // // // // // // // // // // // // // // // // // // // // // // // // // // //

	@Override
	public void update() { }

	
	
}