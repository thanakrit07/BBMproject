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
	protected int countboost;
	protected List<Bomb> bombList = new ArrayList<Bomb>();
	protected List<Hitbox> lhb = new ArrayList<Hitbox>();
	protected Hitbox bounds;

	protected double x, y;
	protected int countBomb;

	public Hero(double x, double y) {
		this.x = x;
		this.y = y;
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
				break;
			}
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

	public void decreaseBombrage() {
		if (this.bombrange > 1) {
			this.bombrange--;
		}
	}

	public void increaseSpeed() {
		if (this.speed < 6) {
			this.speed++;
		} else if (this.speed == 6) {
			this.speed = 7.5;
		} else if (this.speed == 7.5) {
			this.speed = 10;
		}
	}

	public void decreaseSpeed() {
		if (this.speed == 10) {
			this.speed = 7.5;
		} else if (this.speed == 7.5) {
			this.speed = 6;
		} else if (this.speed > 2 || this.speed <= 6) {
			this.speed--;
		}
	}

	public void increaseBombnumber() {
		this.countBomb++;
	}

	public void decreaseBombnumber() {
		if (countBomb > 1) {
			this.countBomb--;
		}
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

	public int getBombrange() {
		return bombrange;
	}

	public int getCountboost() {
		return countboost;
	}

	public void setCountboost(int countboost) {
		this.countboost = countboost;
	}

	public int getCountBomb() {
		return countBomb;
	}
}
