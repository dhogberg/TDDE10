package assets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/** 
 * 
 * Manages the highscores, reads and saves
 * to file and has methods to grab the
 * list
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class Highscores {

	private ArrayList<Integer> highscores = new ArrayList<Integer>();

	public Highscores() {
		this.highscores = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> get_highscores(){
		try {
			FileInputStream file = new FileInputStream("src/data/highscores.ser");
			ObjectInputStream inputfile = new ObjectInputStream(file);
			this.highscores = (ArrayList<Integer>) inputfile.readObject();
			inputfile.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		
		return this.highscores;
	}
	// TODO: Move savescore from PlayerObject to this method 
	/*
	public save_score(int score){
		
	}
	*/
}