package entity;

import java.util.ArrayList;
import java.util.List;

import entity.Bomb;
import javafx.scene.Group;
import object.Gameobject;
import sharedObject.Hitbox;

public abstract class Hero implements Gameobject {

	protected double speed;
	protected int direction;
	protected int bombrange;
	protected List<Bomb> bombList = new ArrayList<Bomb>();
	protected List<Hitbox> lhb = new ArrayList<Hitbox>();
	protected Hitbox bounds;
	
	protected double x,y;

	protected int countBomb = 1;
	public Hero(double x, double y) {
		this.x = x;
		this.y= y;
	}

	protected void moveX() {
		if (direction == 1) {	
			bounds.setLayoutX(bounds.getLayoutX() + speed);
			if (collosion()) {
				bounds.setLayoutX(bounds.getLayoutX() - speed);
			}

		} else if (direction == 3) {
			bounds.setLayoutX(bounds.getLayoutX() - speed);
			if (collosion()) {
				bounds.setLayoutX(bounds.getLayoutX() + speed);

			}
		}
	}

	protected void moveY() {
		
		if (direction == 0) {
			System.out.println("moveY");
			bounds.setLayoutY(bounds.getLayoutY() - speed);
			if (collosion()) {
				System.out.println("Hit");
				bounds.setLayoutY(bounds.getLayoutY() + speed);
			}
		} else if (direction == 2) {
			bounds.setLayoutY(bounds.getLayoutY() + speed);
			if (collosion()) {
				bounds.setLayoutY(bounds.getLayoutY() - speed);
			}
		}
	}

	protected boolean collosion() {
		boolean hit = false;
		System.out.println(lhb.size());
		for (Hitbox h : lhb) {
			if (h.CollosionWith(bounds)) {
				hit = true;
			}
			System.out.println(bounds.getLayoutX());
		}
		return hit;
	}

	protected void DropBomb(Group root, Player1 p1, Player2 p2) {
		if (direction == 0) {
			Bomb bomb = new Bomb(Math.floor(bounds.getBoundsInParent().getMinX() / 60) * 60 + 30,
					Math.ceil(bounds.getBoundsInParent().getMinY() / 60) * 60 - 30, this.bombrange);
			bomb.startBomb(root, p1, p2);
		} else if (direction == 1) {
			Bomb bomb = new Bomb(Math.floor(bounds.getBoundsInParent().getMinX() / 60) * 60 + 30,
					Math.ceil(bounds.getBoundsInParent().getMinY() / 60) * 60 - 30, this.bombrange);
			bomb.startBomb(root, p1, p2);

		} else if (direction == 2) {
			Bomb bomb = new Bomb(Math.floor(bounds.getBoundsInParent().getMinX() / 60) * 60 + 30,
					Math.floor(bounds.getBoundsInParent().getMinY() / 60) * 60 + 30, this.bombrange);
			bomb.startBomb(root, p1, p2);

		} else if (direction == 3) {
			Bomb bomb = new Bomb(Math.ceil(bounds.getBoundsInParent().getMinX() / 60) * 60 - 30,
					Math.ceil(bounds.getBoundsInParent().getMinY() / 60) * 60 - 30, this.bombrange);
			bomb.startBomb(root, p1, p2);
		}

	}

	protected abstract void update();

	public void increaseBombrange() {
		this.bombrange++;
	}

	public void increaseSpeed() {
		this.speed++;
	}

	public void increaseBombnumber() {
		this.countBomb++;
	}

	public List<Hitbox> getlhitbox() {
		return this.lhb;
	}

	public Hitbox getHerobox() {
		return bounds;
	}

	public List<Bomb> getbomblist() {
		return this.bombList;
	}
	protected void clearBomb() {
		this.countBomb--;
	}

	public abstract boolean isAlive();

}
