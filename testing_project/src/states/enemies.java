package states;

import java.util.ArrayList;
import java.util;

import drawComponents.Circle;
import drawComponents.DrawComponent;
import drawComponents.Smiley;
import drawComponents.Square;
import drawComponents.Triangle;

public class enemy {

	public enemy() {
		private ArrayList<DrawComponent> drawComponents = new ArrayList<>();
	}
	public DrawComponent createDrawComponent(Integer x, Integer y, Integer w, Integer h) {
		 
			 	
				return (new Circle(x,y, w, h, this.bg_color, this.bg_color));
		
	}
	public static double getRandomIntegerBetweenRange(Integer min, Integer max){

	    double x = (int)(Math.random()*((max-min)+1))+min;

	    return x;

	
	}

}
