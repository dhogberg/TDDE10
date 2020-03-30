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
	private String informationText;
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

		informationText = "Welcome to Marioshooter!";
		bgColor = new Color(78, 172, 176);
		fontColor = new Color(200, 198, 130);
	}

	/*
	Draws information text to the screen
	 */
	@Override
	public void draw(Graphics g) {
		drawBg(g, bgColor);

		g.setColor(fontColor);
		g.setFont(new Font("Monospace", Font.PLAIN, 30));
		g.drawString(informationText, (SCREEN_WIDTH / 2) - 170, SCREEN_HEIGHT / 2);
	}

	/**
	 *
	 * @param key Keycode of the pressed key
	 *
	 *			This function prints the pressed key to the console
	 *			it's used to show that a change of state has been made
	 *
	 *			For more information see GameState
	 */
	@Override
	public void keyPressed(int key) {
		System.out.println("Trycker på " + KeyEvent.getKeyText(key) + " i MenuState");

		if (key == KeyEvent.VK_ENTER)
			model.switchState(new PlayState(model));
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(0);
	}

	@Override
	public void update() { }
}