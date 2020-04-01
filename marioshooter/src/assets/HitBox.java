package assets;

/** 
 * 
 * TODO: Describe what this class does!
 * 
 * @author David & Johan
 * @version 1.0
 * @since 1.0
 */
public class HitBox {

	private int x1;
	private int y1;

	private int x2;
	private int y2;

	private Boolean disabled;

	public HitBox() {
		this.disabled = true;
	}
	
	public HitBox(int x1, int y1, int x2, int y2) {
		this.disabled = false;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public HitBox(int x1, int y1, int x2, int y2, Boolean disabled) {
		this.disabled = disabled;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void update(XYPoint x1y1, XYPoint x2y2) {
		this.x1 = x1y1.x_as_int();
		this.y1 = x1y1.y_as_int();;
		this.x2 = x2y2.x_as_int();;
		this.y2 = x2y2.y_as_int();;
	}

	public void update(XYPoint x1y1, XYPoint x2y2, Boolean disabled) {
		this.disabled = disabled;
		this.x1 = x1y1.x_as_int();
		this.y1 = x1y1.y_as_int();;
		this.x2 = x2y2.x_as_int();;
		this.y2 = x2y2.y_as_int();;
	}

	public void update(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void update(int x1, int y1, int x2, int y2, Boolean disabled) {
		this.disabled = disabled;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public Boolean disabled (){
		return this.disabled;
	}

	public Boolean intersects (HitBox comparison){
		if(!this.disabled() && !comparison.disabled()){
			if(this.x1 < comparison.x2 && this.x2 > comparison.x1 && this.y1 < comparison.y2 && this.y2 > comparison.y1){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public void disable(){
		this.disabled = true;
	}

	public void enable(){
		this.disabled = false;
	}

	// TODO: Delete this, not needed!
	public void development_only_print_values_to_console(){
		System.out.printf("Hitbox: disabled: %s, x1: %s y1: %s , x2: %s y2: %s \n", this.disabled, this.x1, this.y1, this.x2, this.y2 );
	}

	public void development_only_print_values_to_console_with_name(String name){
		System.out.printf("%s - Hitbox: disabled: %s, x1: %s y1: %s , x2: %s y2: %s \n", name, this.disabled, this.x1, this.y1, this.x2, this.y2 );
	}
}