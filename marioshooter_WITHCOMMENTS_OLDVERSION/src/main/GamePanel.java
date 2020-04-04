package main;

import states.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

/**
 * The GamePanel wraps a JPanel
 *
 * The main responsibilities of the GamePanel are:
 *	  - Handle events (e.g. key events and mouse events)
 *	  - Suplying the game with a Graphics object for painting different states
 */
public class GamePanel extends JPanel {

	private GameModel model;

	public GamePanel(final GameModel model) {
		this.model = model;
		/*
			Sets the preferred size of the panel.
			setPreferredSize() is used instead of setSize()
			because of JFrame's pack() function.

			For more information about this read about pack() / setPreferredSize()
			in JavaDocs online or see comments about pack() in /src/main/GameFrame()
		 */

		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setFocusable(true); // IMPORTANT: makes it possible for this class to handle keyboard input.

		/*
			Adds an anonymous Class KeyAdapter.
			This class is responsible for handling keyPressed events in the GamePanel.

			Another way to do this is by
			implementing the KeyListener Interface.
			For this example however it was not needed
			since i only use one of three functions in the interface.
		 */
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);

				model.keyPressed(e.getKeyCode());
			}
		});
	}

	/**
	 * @param g Graphics object used for painting
	 *		  supplied to us when painting gets scheduled.
	 *
	 *		  This function tells the game model to draw the game on the window
	 *
	 *		  == Extra info ==
	 *		  This function is called implicitly by the GameFrame
	 *		  1. In the main loop of the game (see /src/main/Main) game.repaint() is called
	 *		  2. This triggers repaint() to be scheduled on the JFrame
	 *		  3. When repaint() is called on a parent container (see /srd/main/GameFrame) it tells
	 *		  all its children to also repaint them self
	 *		  4. paintComponent is called
	 */
	public void paintComponent(Graphics g) {
		model.draw(g);
	}
}