package constants;

/**
 * In this file we define some global constants.
 *
 * An interface is one way to store variables that are
 * truly constants and not subject to change during run time.
 *
 * Please note that the problem with global variables
 * is that anyone can change them whenever. This makes
 * it extremely hard to reason about your code. But for
 * constants, this is not a problem since we cannot
 * change them, and therefore they stay the same during
 * the entire execution of the program.
 */

/** 
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public interface Constants {

	/*
	 * Define the size of the window
	 */
	int SCREEN_WIDTH = 1600;
	int SCREEN_HEIGHT = 900;
	/*
	 * Define visual options
	 */
	String font = "Monospace";
	
	/*
	 * Define the playingfield size and position
	 */
	int PLAYFIELD_WIDTH = 1200;
	int PLAYFIELD_HEIGHT = 900;
	int PLAYFIELD_XPOS = 400;
	int PLAYFIELD_YPOS = 0;

	/*
	 * Define the drawingarea size and position
	 */
	int ACTIVEDRAWAREA_WIDTH = 1400;
	int ACTIVEDRAWAREA_HEIGHT = 1100;
	int ACTIVEDRAWAREA_XPOS = 300;
	int ACTIVEDRAWAREA_YPOS = -100;
	
	/*
	 * Define the sidebar size and position
	 */
	int SIDEBAR_WIDTH = 400;
	int SIDEBAR_HEIGHT = 900;
	int SIDEBAR_XPOS = 0;
	int SIDEBAR_YPOS = 0;

	/*
	 * Define the desired FPS
	 */
	double FPS = 120.0;

	/*
	 * Define options for player
	 */
	int PLAYERLIFES = 1;
	double PLAYER_BLINKINTERVAL = 0.15;
	double PLAYER_SHOOTINTERVAL = 0.3;

	/*
	 * Developer-options
	 */
	Boolean DEV_SHOW_ACTIVE_KEYS = false;
}