package envi;

import com.sun.prism.paint.Color;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import sharedObject.Hitbox;

public class Brick extends Envi{
	private Hitbox hitbox;
	public Brick(double x,double y) {
		super(x,y);
		this.hitbox= new Hitbox(x,y,60,60);
		hitbox.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("wall.png").toString())));
		hitbox.setVisible(false);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
}
