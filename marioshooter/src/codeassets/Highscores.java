package codeassets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public void save_score(int score){
		ArrayList<Integer> highscores = new ArrayList<Integer>(this.get_highscores());
		highscores.add(score);
		try {
			FileOutputStream file = new FileOutputStream("src/data/highscores.ser");
			ObjectOutputStream outfile = new ObjectOutputStream(file);
			outfile.writeObject(highscores);
			outfile.close();
			file.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}