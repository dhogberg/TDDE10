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

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class GameoverState extends GameState{
	
	private String titel_text;
	
	private MenuButton back_to_menu;

	private Color bgColor;
	private Color fontColor;

	/**
	 * The following three variables are just used to show that a
	 * change of state can be made. The same variables also exist
	 * in the PlayState, can you think of a way to make this more
	 * general and not duplicate variables?????
	 */

	public GameoverState(GameModel model) {
		super(model);
		
		titel_text = "Game over";
		String test = Integer.toString(SCREEN_WIDTH);
		String test2 = Integer.toString(SCREEN_HEIGHT);
		
		int startX = SCREEN_WIDTH/2;
		int startY = SCREEN_HEIGHT/3;
		int space = 100;
		
		back_to_menu = new MenuButton("Menu", new XYPoint(startX,startY+(space*2)), new XYPoint(350,75));
		
		bgColor = new Color(91, 149, 254);
		fontColor = new Color(255, 255, 255);
	}
	
	public void mouseClicked(MouseEvent e) {
		if(back_to_menu.containsXY(e.getX(), e.getY())) {
			System.out.println("changeState to MenuState");
			model.switchState(new MenuState(model));
		}
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		drawBg(g, bgColor);

		g.setColor(fontColor);
		g.setFont(new Font("Monospace", Font.PLAIN, 60));
		g.drawString(titel_text, (SCREEN_WIDTH / 2) - 400, SCREEN_HEIGHT / 5 );
		
		g.drawString("Your score was", (SCREEN_WIDTH / 2) - 400, SCREEN_HEIGHT / 3 );
		
		g.drawString( Integer.toString(this.model.get_lastScore()) , (SCREEN_WIDTH / 2) - 400, SCREEN_HEIGHT / 3 + 60);
		
		back_to_menu.draw(g2);

	}
	
	public void keyPressed(int key) {
		// TODO: Add keyboard functionality
	}
	public void keyReleased(int key) {
		// TODO: Add keyboard functionality
	}
	
	public void startPressed(MouseEvent e) {
		System.out.println("d�");
	}
	
	@Override
	public void update() {}
}