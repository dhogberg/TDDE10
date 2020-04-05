package states;

import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import gameobjects.GameObject;
import gameobjects.PlayerObject;
import gameobjects.PlayfieldObject;
import gameobjects.SidebarObject;
import levels.GameLevels;
import states.GameModel;

import static constants.Constants.DEV_SHOW_ACTIVE_KEYS;

/** 
 * 
 * TODO: This class is used to represent the current state
 * of the game when playing. It contains the data of the player and all the objects on the playfield
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class PlayStateModel extends GameState{
	private GameLevels lvl; 
	private PlayerObject playerObject;
	private SidebarObject sidebarObject;
	private PlayfieldObject playfieldObject;
	private ArrayList<GameObject> gameobjects;
	private ArrayList<GameObject> playerbullets;
	private Set<Integer> active_keys = new HashSet<Integer>();

	public PlayStateModel(GameModel model) {
		super(model);
		gameobjects = new ArrayList<GameObject>();
		this.playfieldObject = new PlayfieldObject();
		this.lvl = new GameLevels(this);
		playerbullets = new ArrayList<GameObject>();
		this.playerObject = new PlayerObject(this.playerbullets, model);
		this.sidebarObject = new SidebarObject(playerObject, lvl);
		playerObject.set_name("Player1");
	}
	
	public void mousePressed(MouseEvent e) {
		// Here we can add mouseclickevents in the future
	}
	
	public void mousePressed(int x, int y) {
		// Here we can add mouseclickevents in the future
	}

	public int getCurrentLevel() {
		return this.lvl.getLevel();
	}
	
	public PlayfieldObject get_playfieldobject() {
		return this.playfieldObject;
	}
	
	public void change_playfieldobj_bgcolor(Color color) {
		this.playfieldObject.set_bgcolor(color);
	}

	public ArrayList<GameObject> get_gameobjects(){
		return this.gameobjects;
	}
	
	public PlayerObject test_get_player() {
		return this.playerObject;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		this.drawObjects(g2);
	}
	
	public void drawObjects(Graphics2D g2) {
		// Draw playingfield
		playfieldObject.draw(g2);	
		
		// To avoid concurrentModification, we copy the list
		// beforehand and then we loop through the copy
		final ArrayList<GameObject> copyof_gameobjects = new ArrayList<GameObject>(this.gameobjects);
		final ArrayList<GameObject> copyof_playerbullets = new ArrayList<GameObject>(this.playerbullets);
		
		// Draw gameobjects 
		for (GameObject obj : copyof_gameobjects) {
			obj.draw(g2);
		}
		
		// Draw playerbullets
		for (GameObject obj : copyof_playerbullets) {
			obj.draw(g2);
		}
		
		// Draw playerobject
		playerObject.draw(g2);
		
		// Draw sidebar
		sidebarObject.draw(g2);
	}
	
	public void update() {
		// Required
	}
	
	public void update(double executionTime) {
		//gameobjects.add(new BulletenemyObject("bullet1"));
		this.updateObjects(executionTime, this.active_keys);
	}
	
	public void updateObjects(double executionTime, Set<Integer> active_keys) {		

		// UPDATE PLAYER
		playerObject.update(executionTime, active_keys);
		
		// UPDATE LEVEL
		this.lvl.update(executionTime);

		// UPDATE OBJECTS
		for (GameObject obj : this.gameobjects) {
			obj.update(executionTime);
		}
		
		// UPDATE PLAYERBULLETS
		for (GameObject obj : this.playerbullets) {
			obj.update(executionTime);
		}
		
		// UPDATE PLAYER HITBOX
		for (GameObject obj : this.gameobjects) {
			if(playerObject.hitbox().intersects(obj.hitbox())) {
				playerObject.collideWithGameobject(obj);
				obj.collideWithPlayer();
			}
		}
		
		// UPDATE PLAYERBULLETS HITBOXES
		for (GameObject obj : this.playerbullets) {
			for (GameObject obj2 : this.gameobjects) {
				if(obj.hitbox().intersects(obj2.hitbox())) {
					obj.collideWithGameobject(obj2);
					obj2.collideWithGameobject(obj);
				}
			}
		}
		
		// ADD OBJECTS FOR DELETION WHICH ARE OUTSIDE SCREEN
		final ArrayList<GameObject> tmp_remove_objs = new ArrayList<GameObject>();
		
		for (GameObject obj : this.gameobjects) {
			if(obj.outsideDrawingArea()) {
				System.out.printf("OBJECT with name %s IS OUTSIDE SCREEN!\n", obj.get_name());
				tmp_remove_objs.add(obj);
			}
		}
		
		// DELETE THE OBJECTS OUTSIDE SCREEN FROM LIST GENERATED ABOVE
		for (GameObject obj : tmp_remove_objs) {
			System.out.printf("OBJECT with name %s GOT DELETED FROM GAMEOBJECTS ARRAYLIST!\n", obj.get_name());
			this.gameobjects.remove(obj);
		}

		if(DEV_SHOW_ACTIVE_KEYS){ // Development test code
			System.out.printf("Active keys: %s\n",active_keys);
		}
	}

	public void keyPressed(int keycode) {
		active_keys.add(keycode);
	}

	public void keyReleased(int keycode) {
		active_keys.remove(keycode);
	}

}