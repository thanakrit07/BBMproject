package entity;

import object.Gameobject;
import sharedObject.Hitbox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bomb extends Gameobject{
	private boolean exploded;
	private int bombrange;
	private Hitbox bomb;
	public Bomb(double x,double y,int bombrange) {
		super(x,y);
		this.exploded = false;
		this.bombrange=bombrange;
		bomb =new Hitbox(x,y,60,60);
		bomb.setFill(Color.GRAY);
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

}
