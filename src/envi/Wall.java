package envi;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.Hitbox;

public class Wall extends Envi{
	private Hitbox hitbox;
	public Wall(double x, double y, double w, double h) {
		super(x, y, w, h);
		this.hitbox= new Hitbox(x,y,60,60);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.WHITE);
		gc.fillRect(this.x, this.y, 60, 60);
	}
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
