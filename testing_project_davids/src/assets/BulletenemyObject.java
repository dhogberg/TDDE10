package assets;

import java.awt.image.BufferedImage;
import main.Main;

public class BulletenemyObject extends GameObject {
	
	private BufferedImage objectGraphic;
	
	public BulletenemyObject() {
		super();
		this.objectGraphic = Main.loadImage("sprites/bullet_enemy_16x14.png"); // TODO: SKRIV OM SKRIV OM
		this.set_objectGraphic(this.objectGraphic);
		this.set_scale(2.0);
		set_objectGraphic_width(16);
		set_objectGraphic_height(14);
		this.set_position(100.0, 100.0);
	}
	
	@Override
	public void update(double executionTime) {
		super.update(executionTime);
		// TODO: Update specific things for the BulletenemyObject
	}
}