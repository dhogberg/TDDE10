package states;

import java.awt.*;
import java.awt.event.KeyEvent;



import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

/**
 * This state represents the menu of the Game
 * The main responsibility of this class is to allow
 * the user to swap state to the PlayState
 */
public class MenuState extends GameState {
	
	private String titel_text;
	private String startgame_text;
	private String highscores_text;
	private String info_text;
	private String quit_text;

	private Color bgColor;
	private Color fontColor;

	/**
	 * The following three variables are just used to show that a
	 * change of state can be made. The same variables also exist
	 * in the PlayState, can you think of a way to make this more
	 * general and not duplicate variables?????
	 */
	public MenuState(GameModel model) {
		super(model);
		
		titel_text = "Marioshooter JAVA OOP Game";
		
		//startgame_text = new MenuButton("Start Game", new XYPoint(400.0, 600.0));
		
		startgame_text = "Start game";
		highscores_text = "Highscores";
		info_text = "Info";
		quit_text = "Quit game";

		bgColor = new Color(91, 149, 254);
		fontColor = new Color(255, 255, 255);
		
		//model.switchState(new PlayState(model));
	}

	@Override
	public void draw(Graphics g) {
		drawBg(g, bgColor);

		g.setColor(fontColor);
		g.setFont(new Font("Monospace", Font.PLAIN, 60));
		g.drawString(titel_text, (SCREEN_WIDTH / 2) - 400, SCREEN_HEIGHT / 5 );

		g.drawString(startgame_text, (SCREEN_WIDTH / 2) - 150, SCREEN_HEIGHT / 10 * 4 );
		g.drawString(highscores_text, (SCREEN_WIDTH / 2) - 150, SCREEN_HEIGHT / 10 * 5 );
		g.drawString(info_text, (SCREEN_WIDTH / 2) - 150, SCREEN_HEIGHT / 10 * 6 );
		g.drawString(quit_text, (SCREEN_WIDTH / 2) - 150, SCREEN_HEIGHT / 10 * 7 );

	}
	
	public void keyPressed(int key) {
		// TODO: Add keyboard functionality
	}
	public void keyReleased(int key) {
		// TODO: Add keyboard functionality
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