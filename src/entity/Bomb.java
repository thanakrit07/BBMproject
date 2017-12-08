package entity;

import object.Gameobject;
import sharedObject.Hitbox;

import javafx.scene.shape.Rectangle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bomb extends Gameobject{
	private boolean exploded;
	private int bombrange;
	private Hitbox bomb;
	protected Thread thread;
	private double x;
	private double y;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	public Bomb(double x,double y,int bombrange) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.exploded = false;
		this.bombrange=bombrange;
		bomb =new Hitbox(x,y,60,60);
		bomb.setFill(Color.GRAY);
	}
//	public void drawEffectBomb(GraphicsContext gc) {
//		gc.setFill(Color.AQUA);
//		gc.fillRect(x + 60, y, 60 * bombrange, 60);
//		gc.fillRect(x - (60 * bombrange), y, 60 * bombrange, 60);
//		gc.fillRect(x, y - (60 * bombrange), 60, 60 * bombrange);
//		gc.fillRect(x, y + 60, 60, 60 * bombrange);
//	}
	public boolean IsExploded() {
		return this.exploded;
	}
	public int getZ() {
		return 0;
	}
	public void startBomb() {
		thread = new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.exploded = true;
			bomb.setFill(Color.WHITE);
			for (int i=1;i<=bombrange;i++) {
				
				//check wall
				
				Rectangle u = new Rectangle(x,y+(i*60),60.0,60.0);
				u.setFill(Color.YELLOW);
				Rectangle d = new Rectangle(x,y-(i*60),60.0,60.0);
				d.setFill(Color.YELLOW);
				Rectangle l = new Rectangle(x-(i*60),y,60.0,60.0);
				l.setFill(Color.YELLOW);
				Rectangle r = new Rectangle(x+(i*60),y,60.0,60.0);
				r.setFill(Color.YELLOW);
				
			}
		});
	}

}
