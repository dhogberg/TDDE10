package states;

import java.awt.*;
import java.awt.event.MouseEvent;

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

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class PlayState extends GameState {
	
	private PlayStateModel playStateModel;
	private long lastTime = System.currentTimeMillis();

	public PlayState(GameModel model) {
		super(model);
		this.playStateModel = new PlayStateModel(model);
	}

	@Override
	public void draw(Graphics g) {
		this.playStateModel.draw(g);
	}

	@Override
	public void update() {
		long timeNow = System.currentTimeMillis();
		double executionTime = (timeNow - this.lastTime) / 1000.0;
		this.playStateModel.update(executionTime);
		this.lastTime = timeNow;
	}
	
	public void mousePressed(MouseEvent e) {
		// Here it is possible to add mouseclick events
	}
	
	public void mousePressed(int x, int y) {
		// Here it is possible to add mouseclick events
	}
	
	public void keyPressed(int key) {
		this.playStateModel.keyPressed(key);
	}
	public void keyReleased(int key) {
		this.playStateModel.keyReleased(key);
	}
}