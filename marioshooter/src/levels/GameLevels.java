package levels;

import states.PlayModel;
import java.util.ArrayList;
import java.util.Random;

import gameobjects.BulletenemyObject;
import gameobjects.GameObject;
import gameobjects.LifeupObject;
import gameobjects.MushroomObject;
import gameobjects.ShellenemyObject;
import gameobjects.StarObject;

import java.awt.Color;

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class GameLevels {
	
	private int level;
	private PlayModel playStateModel_reference;
	
	private double BULLETENEMY_spawn_pause_timer;
	private double BULLETENEMY_spawn_pause_interval;
	
	private double POWERUP_spawn_pause_timer;
	private double POWERUP_spawn_pause_interval;

	private double elapsed_time_on_level;
	
	public GameLevels(PlayModel playStateModel) {
		this.playStateModel_reference = playStateModel;
		this.BULLETENEMY_spawn_pause_interval = 2.0;
		this.POWERUP_spawn_pause_interval = 2.0;
		loadLvl(1);
	}
	
	public int getLevel() {
		return this.level;
	}

	public void loadLvl(int lvl){
		this.elapsed_time_on_level = 0.0;
		this.BULLETENEMY_spawn_pause_interval = 1.0 / (lvl * lvl);
		this.POWERUP_spawn_pause_interval = 2.0;
		this.level = lvl;
		int tmp_lvl = lvl;
		
		Random ran = new Random();
		Random ran2 = new Random();
		
		int select_r_or_g_or_b = ran2.nextInt(3);
		
		final int r;
		final int g;
		final int b;
		
		switch(select_r_or_g_or_b) {
			case 0:
				r = 200 + ran.nextInt(56);
				g = 200;
				b = 200;
				break;
			case 1:
				r = 200;
				g = 200 + ran.nextInt(56);
				b = 200;
				break;
			case 2:
				r = 200;
				g = 200;
				b = 200 + ran.nextInt(56);
				break;
			default:
				r = 255;
				g = 255;
				b = 255;
		}
		
		final Color test = new Color(r,g,b);
		
		this.playStateModel_reference.change_playfieldobj_bgcolor(test);
	}

	public void updateSpawns(double executionTime){
		
		// SPAWN ENEMIES
		Random ran7 = new Random();
		int enemy_index = ran7.nextInt(2);
		if(BULLETENEMY_spawn_pause_timer == 0.0){
			// SPAWN!
			switch(enemy_index) {
				case 0:
					playStateModel_reference.get_gameobjects().add(new BulletenemyObject("bullet1"));
					break;
				case 1:
					playStateModel_reference.get_gameobjects().add(new ShellenemyObject("shell1"));
					break;
			}
			BULLETENEMY_spawn_pause_timer = BULLETENEMY_spawn_pause_interval / this.level;
		}else{
			if(BULLETENEMY_spawn_pause_timer < executionTime){
				BULLETENEMY_spawn_pause_timer = 0.0;
			}else{
				BULLETENEMY_spawn_pause_timer = BULLETENEMY_spawn_pause_timer - executionTime;
			}
		}
		
		// SPAWN POWERUP
		Random ran = new Random();
		int powerup_index = ran.nextInt(3);
		if(POWERUP_spawn_pause_timer == 0.0){
			// SPAWN!
			switch(powerup_index) {
				case 0:
					playStateModel_reference.get_gameobjects().add(new StarObject("star1"));
					break;
				case 1:
					playStateModel_reference.get_gameobjects().add(new LifeupObject("life1"));
					break;
				case 2:
					playStateModel_reference.get_gameobjects().add(new MushroomObject("mushroom1"));
					break;
			}
			POWERUP_spawn_pause_timer = POWERUP_spawn_pause_interval;
		}else{
			if(POWERUP_spawn_pause_timer < executionTime){
				POWERUP_spawn_pause_timer = 0.0;
			}else{
				POWERUP_spawn_pause_timer = POWERUP_spawn_pause_timer - executionTime;
			}
		}
		
		
	}

	public void update (double executionTime){
		this.elapsed_time_on_level = this.elapsed_time_on_level + executionTime;
		//System.out.printf("Elapsed time on level: %s\n",elapsed_time_on_level);
		
		// UPDATE SPAWNS
		this.updateSpawns(executionTime);

		if(this.elapsed_time_on_level > 10.0) {
			loadLvl(this.level + 1);
		}
	}
}