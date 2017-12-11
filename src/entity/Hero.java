package entity;

import java.util.ArrayList;
import java.util.List;

import entity.Bomb;
import envi.Envi;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import object.Gameobject;
import sharedObject.Hitbox;

public abstract class Hero extends Gameobject {

	protected double speed = 5;
	protected int direction;
	protected int bombrange;
	protected List<Bomb> bombList = new ArrayList<Bomb>();
	protected List<Hitbox> lhb = new ArrayList<Hitbox>();
	// protected static boolean alive;
	protected Hitbox bounds;

	protected int countBomb = 1;

	public Hero(double x, double y) {
		super(x, y);
		// this.alive = true;
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
			bounds.setLayoutY(bounds.getLayoutY() - speed);
			if (collosion()) {
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
		for (Hitbox h : lhb) {
			if (h.CollosionWith(bounds)) {
				hit = true;
			}
		}
		return hit;
	}
	protected void DropBomb(Group root, int[][] field, List<Hitbox> lbrick, Player1 p1, Player2 p2) {
		if (direction == 0) {
			Bomb bomb = new Bomb(Math.floor(bounds.getBoundsInParent().getMinX() / 60) * 60 + 30,
			Math.ceil(bounds.getBoundsInParent().getMinY() / 60) * 60 - 30, this.bombrange);
			bomb.startBomb(root, field, lbrick, p1, p2);

		} else if (direction == 1) {
			Bomb bomb = new Bomb(Math.floor(bounds.getBoundsInParent().getMinX() / 60) * 60 + 30,
			Math.ceil(bounds.getBoundsInParent().getMinY() / 60) * 60 - 30, this.bombrange);
			bomb.startBomb(root, field, lbrick, p1, p2);

		} else if (direction == 2) {
			Bomb bomb = new Bomb(Math.floor(bounds.getBoundsInParent().getMinX() / 60) * 60 + 30,
			Math.floor(bounds.getBoundsInParent().getMinY() / 60) * 60 + 30, this.bombrange);
			bomb.startBomb(root, field, lbrick, p1, p2);

		} else if (direction == 3) {
			Bomb bomb = new Bomb(Math.ceil(bounds.getBoundsInParent().getMinX() / 60) * 60 - 30,
			Math.ceil(bounds.getBoundsInParent().getMinY() / 60) * 60 - 30, this.bombrange);
			bomb.startBomb(root, field, lbrick, p1, p2);
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
