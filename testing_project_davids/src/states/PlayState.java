package states;

import testing.Tester;

import java.awt.*;
import java.awt.event.KeyEvent;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

/**
 * This state represents the Playing State of the Game
 * The main responsibility of this class is to;
 *	  - create Game Objects
 *	  - update Game Objects
 *	  - draw   Game Objects
 * Game Objects are for instance; players, enemies, npc's, etc...
 *
 * The PlayState can also be thought off
 * as a blue print where data is loaded into
 * som container from a file
 * or some other type of data storage.
 *
 * It can also be created
 * by some class responsible for
 * object creation and then passed to the
 * PlayState as a parameter. This means all the
 * PlayState has to do is recive a list of
 * objects, store them in som container
 * and then for every object in that container
 * update and render that object.
 *
 * This way you can let the user
 * define different Levels
 * based on what parameters
 * are passed into the PlayState.
 */
public class PlayState extends GameState {
	private String informationText;
	private Color bgColor;
	private Color fontColor;

	/* Class only used for testing */
	private Tester tester;

	/**
	 * The following three variables are just used to show that a
	 * change of state can be made. The same variables also exist
	 * in the MenuState, can you think of a way to make this more
	 * general and not duplicate variables?????
	 */
	public PlayState(GameModel model) {
		super(model);
		informationText = "Press Escape To Return To The Menu";
		bgColor = new Color(78, 87, 100);
		fontColor = new Color(123, 178, 116);

		tester = new Tester();
	}

	/*
		Draws information text to the screen.
	 */
	@Override
	public void draw(Graphics g) {
		drawBg(g, bgColor);

		g.setColor(fontColor);
		g.setFont(new Font("Monospace", Font.PLAIN, 20));
		g.drawString(informationText, (SCREEN_WIDTH / 2) - 200, SCREEN_HEIGHT / 2);

		tester.delegate(g);
	}

	@Override
	public void keyPressed(int key) {
		System.out.println("Trycker på " + KeyEvent.getKeyText(key) + " i PlayState");

		if (key == KeyEvent.VK_ESCAPE)
			model.switchState(new MenuState(model));
	}

	@Override
	public void update() {
		tester.delegate(null);
	}
}