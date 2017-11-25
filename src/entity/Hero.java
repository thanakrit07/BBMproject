package entity;

import java.util.ArrayList;
import java.util.List;

import entity.Bomb;
import javafx.scene.shape.Rectangle;
import object.Gameobject;
import sharedObject.Hitbox;

public abstract class Hero extends Gameobject {

	protected int speed;
	protected int direction = 0;
	protected int bombrange;
	protected List<Bomb> bombList = new ArrayList<Bomb>();
	protected List<Hitbox> lhb = new ArrayList<Hitbox>();
	protected boolean alive;
	protected Rectangle unit;

	public Hero(double x, double y) {
		super(x, y, 60, 60);
		this.alive = true;
		unit = new Rectangle(x, y, 60, 60);
	}


	protected  void moveX() {
		if (direction == 1) {
			if (!collosion()) {
				this.x += speed;
				this.unit.setX(this.x);
			}
			else {
				this.x = this.x-speed-0.1;
				this.unit.setX(this.x);
			}
			
		} 
		else if(direction == 3){
			if (!collosion()) {
				this.x -= speed;
				this.unit.setX(this.x);
			}
			else {
				this.x =this.x+ speed+0.1;
				this.unit.setX(this.x);
			}
		}
	}
	protected void moveY() {
		if (direction == 0) {
			
			if (!collosion()){
				this.y -= speed;
			}			
			else
				this.y = this.y+speed+0.1;
		} else if (direction == 2) {
			if (!collosion())
				this.y += speed;
			else
				this.y = this.y-speed-0.1;
		}
		this.unit.setY(this.y);
	}

	protected boolean collosion() {
		boolean hit = false;
		for (Hitbox h : lhb) {
			if (h.CollosionWith(unit)) {
				hit = true;
			}
		}
		return hit;
	}

	protected void DropBomb() {
		Bomb bomb = new Bomb(this.x, this.y, 60, 60, this.bombrange);
		// bomb.setVisible(true);
		this.bombList.add(bomb);
	}

	public int getZ() {
		return 0;
	}
	public List<Hitbox> getlhitbox(){
		return this.lhb;
	}

	protected abstract void update();
}
