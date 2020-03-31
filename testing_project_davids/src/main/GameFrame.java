package main;

import states.GameModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * This class Wraps a JFrame:
 *
 *	A JFrame is a top level Swing container
 *	used to show a Window on the screen.
 *	The JFrame serves as the root of the
 *	containment hierarchy and contains all
 *	other Swing components that appear inside
 *	the top level container.
 *
 *	A JFrame is used for wrapping other components
 *	like buttons, bars, panels etc.
 *
 * The GameFrame is responsible for creating the Window
 * with the desired properties. For more information see Comments below.
 *
 */
public class GameFrame extends JFrame {

	public GameFrame(String gameName, GameModel model){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates the program when window closes
		this.setResizable(false);

		this.add(new GamePanel(model)); // Create a new GamePanel and add's it to the frame

		/*
			Adjusts the size of the frame to fit it's children (GamePanel).

			IMPORTANT: This only works if the children set their size using
					   setPreferredSize(new Dimension(width, height));
					   If the children use setSize(), components that don't fit
					   will be placed outside of the frame, making them not visible.
		 */
		this.pack();
		this.setLocationRelativeTo(null); // Sets location of frame to mid point of screen
		this.setName(gameName);
		this.setVisible(true); // Shows the frame
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				model.keyPressed(e.getKeyCode());
				//System.out.printf("KEY PRESSED: %s\n", e.getKeyChar());

				
				//keys.add(e.getKeyCode());
				//model.setKeys(keys);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				model.keyReleased(e.getKeyCode());
				//keys.remove(e.getKeyCode());
				//model.setKeys(keys);
			}
		});
		
		this.requestFocus();
	}
}