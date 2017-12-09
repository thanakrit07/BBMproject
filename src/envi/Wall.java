package envi;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.Hitbox;

public class Wall extends Envi{
	private Hitbox hitbox;
	public Wall(double x, double y) {
		super(x, y);
		this.hitbox= new Hitbox(x,y,60,60);
		hitbox.setFill(Color.BLANCHEDALMOND);
		hitbox.setVisible(false);
	}


	public Hitbox getHitbox() {
		return hitbox;
	}

}
