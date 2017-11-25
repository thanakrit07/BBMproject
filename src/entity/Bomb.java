package entity;

import object.Gameobject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bomb extends Gameobject{
	private boolean exploded;
	private int bombrange;
	public Bomb(double x,double y,double w,double h,int bombrange) {
		super(x,y,w,h);
		this.exploded = false;
		this.bombrange=bombrange;
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillOval(x, y, 60, 60);
	}
	public void drawEffectBomb(GraphicsContext gc) {
		gc.setFill(Color.AQUA);
		gc.fillRect(x + 60, y, 60 * bombrange, 60);
		gc.fillRect(x - (60 * bombrange), y, 60 * bombrange, 60);
		gc.fillRect(x, y - (60 * bombrange), 60, 60 * bombrange);
		gc.fillRect(x, y + 60, 60, 60 * bombrange);
	}
	public boolean IsExploded() {
		return this.exploded;
	}
	public int getZ() {
		return 0;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}
