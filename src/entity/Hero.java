package entity;

import java.util.ArrayList;
import java.util.List;

import entity.Bomb;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import object.Gameobject;
import sharedObject.Hitbox;

public abstract class Hero extends Gameobject {

	protected double speed = 5;
	protected int direction = 0;
	protected int bombrange;
	protected List<Bomb> bombList = new ArrayList<Bomb>();
	protected List<Hitbox> lhb = new ArrayList<Hitbox>();
	protected boolean alive;
	protected Hitbox bounds;

	public Hero(double x, double y) {
		super(x, y);
		this.alive = true;
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

	protected void DropBomb() {
		Bomb bomb = new Bomb(this.x, this.y, this.bombrange);
		// bomb.setVisible(true);
		this.bombList.add(bomb);
	}

	public int getZ() {
		return 0;
	}

	public List<Hitbox> getlhitbox() {
		return this.lhb;
	}

	public Hitbox getHerobox() {
		return this.bounds;
	}

	// protected abstract void update();

}
