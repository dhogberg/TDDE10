package states;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * This class represents the current state of the game.
 *
 * This implementation of a state machine keeps a reference to
 * the current state (see /src/states/GameState).
 *
 * Please note: This is just one way to do it, there are several
 * other ways and none of them work for every case, so if you
 * want to implement your own state machine make sure that
 * it can do all the operations that you need for your project.
 *
 * To change state simply call the switchState(GameState nextState) function
 * passing a reference to some other gameState.
 *
 * Initial State: MenuState
 *
 */

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class GameModel {

	private GameState currentState;

	protected Long lastTime;
	
	private int lastScore;

	public GameModel() {
		this.currentState = new MenuState(this);
	}
	
	public void set_lastScore(int score) {
		this.lastScore = score;
	}
	
	public int get_lastScore() {
		return this.lastScore;
	}

	/**
	 * Switch to a new state, stored in the 'state' reference.
	 *
	 * This will call 'deactivate' on the current state,
	 * then store the new state as the current state, and finally call
	 * 'activate' on the new current state.
	 */
	public void switchState(GameState nextState) {
		currentState.deactivate();
		currentState = nextState;
		currentState.activate();
	}

	
	public void mouseClicked(MouseEvent e) {
		currentState.mouseClicked(e);
	}
	
	
	/**
	 * Delegates the keyPress from GamePanel to the current state
	 * @param key
	 */
	public void keyPressed(int key) {
		currentState.keyPressed(key);
	}
	public void keyReleased(int key) {
		currentState.keyReleased(key);
	}

	/**
	 * The update function is called every iteration of the game loop.
	 * it's usually used to update the games logic e.g. objects position, velocity, etc...
	 */
	public void update() {
		currentState.update();
	}

	/**
	 * New version of update, takes in the start current time in ms
	 * so we can calculate variance in speed depending on changes in fps
	 */
	public void update(Long startTime_ms) {
		currentState.update();
		this.lastTime = startTime_ms;
	}

	/**
	 * @param g Graphics object passed from GamePanel
	 *		  This function delegates drawing from the GamePanel to the current state
	 */
	public void draw(Graphics g) {
		currentState.draw(g);
	}
	
	public Long get_lastTime() {
		return this.lastTime;
	}
}