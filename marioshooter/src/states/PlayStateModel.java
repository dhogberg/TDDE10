package states;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import constants.Constants;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import static constants.Constants.DEV_SHOW_ACTIVE_KEYS;

import assets.GameObject;
import assets.PlayerObject;
import assets.PlayerbulletObject;
import assets.PlayfieldObject;
import assets.SidebarObject;
import assets.BulletenemyObject;
import assets.LifeupObject;
import assets.StarObject;
import assets.GameLevels;
import states.GameModel;

/** 
 * 
 * TODO: This an important class used to represent the current state
 * of the game when playing. It contains the data of the player and all the objects on the playfield
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class PlayStateModel extends GameState{
	
	private PlayState playStateReference;
	private PlayerObject playerObject;
	private PlayfieldObject playfieldObject;
	private SidebarObject sidebarObject;
	private Set<Integer> active_keys = new HashSet<Integer>();
	private ArrayList<GameObject> gameobjects;
	private ArrayList<GameObject> playerbullets;
	private GameLevels lvl; 

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
	
	public void mouseClicked(MouseEvent e) {
		// Here we can add mouseclicks
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
		
		
		/*
		 * To avoid concurrentModification, we copy the list
		 * beforehand and then we loop through the copy
		 */
		
		
		// Draw gameobjects
		final ArrayList<GameObject> copyof_gameobjects = new ArrayList<GameObject>(this.gameobjects);
		
		// Draw playerbullets
		final ArrayList<GameObject> copyof_playerbullets = new ArrayList<GameObject>(this.playerbullets);
		
		for (GameObject obj : copyof_gameobjects) {
			obj.draw(g2);
		}
		
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
		
		// DELETE THE OBJECTS
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