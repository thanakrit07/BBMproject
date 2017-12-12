package sharedObject;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Hitbox extends Rectangle{
	public Hitbox(double x, double y, double w, double h) {
		super(x, y, w, h);
	}
	// check collosion

	public boolean CollosionWith(Rectangle other) {
		boolean collosion = false;
		Shape intersect = Shape.intersect(this,other);
		double checkW = intersect.getBoundsInLocal().getWidth();
		double checkH = intersect.getBoundsInLocal().getHeight();
//		System.out.println(checkW);
//		System.out.println(checkH);
		if (checkW != -1 || checkH != -1) {
			collosion = true;
			
		}
		return collosion;
	}
}
