package assets;

import states.PlayStateModel;
import java.util.ArrayList;

public class GameLevels {
	
	private int level;
	private PlayStateModel playStateModel_reference;
	private ArrayList<GameObject> gameobjects_reference;
	
	private double spawn_pause_timer;
	private double spawn_pause_interval;
	private double elapsed_time_on_level;
	
	public GameLevels(PlayStateModel playStateModel) {
		this.playStateModel_reference = playStateModel;
		this.spawn_pause_interval = 2.0;
		loadLvl(20);
	}
	
	public int getLevel() {
		return this.level;
	}

	public void loadLvl(int lvl){
		this.spawn_pause_timer = 0.0;
		this.elapsed_time_on_level = 0.0;
		this.level = lvl;
		
		int tmp_lvl = lvl;
		
		while(tmp_lvl > 0) {
			playStateModel_reference.get_gameobjects().add(new BulletenemyObject("bullet1"));
			tmp_lvl--;
		}
	}

	public void updateSpawns(double executionTime){
		if(this.spawn_pause_timer == 0.0){
			System.out.println("RUNS: 1");
			// SPAWN!
			playStateModel_reference.get_gameobjects().add(new BulletenemyObject("bullet1"));
			spawn_pause_timer = spawn_pause_interval / this.level;
		}else{
			System.out.println("RUNS: 2");
			if(spawn_pause_timer < executionTime){
				spawn_pause_timer = 0.0;
			}else{
				spawn_pause_timer = spawn_pause_timer - executionTime;
			}
		}
	}

	public void update (double executionTime){
		//System.out.printf("Elapsed_time_on_level: %s\n",elapsed_time_on_level);
		this.elapsed_time_on_level = this.elapsed_time_on_level + executionTime;

		// UPDATE SPAWNS
		this.updateSpawns(executionTime);
	}
}