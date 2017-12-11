package envi;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import sharedObject.Hitbox;

public class Wall extends Envi{
	private Hitbox hitbox;
	public Wall(double x, double y) {
		super(x, y);
		this.hitbox= new Hitbox(x,y,60,60);
		hitbox.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("wall.png").toString())));
		hitbox.setVisible(true);
	}
	public Hitbox getHitbox() {
		return hitbox;
	}

}
