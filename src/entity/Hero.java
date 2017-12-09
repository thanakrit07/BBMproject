package entity;

import java.util.ArrayList;
import java.util.List;

import entity.Bomb;
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
	
	protected void DropBomb(Group root,int[][] field) {
		Bomb bomb;
		if (direction==0) {
			bomb = new Bomb(Math.floor(bounds.getLayoutX()/60)*60+30, Math.ceil(bounds.getLayoutY()/60)*60+30, this.bombrange);
			root.getChildren().add(bomb.getUnitbox());
			bomb.startBomb(root,field);
		}else if(direction==1){
			bomb = new Bomb(Math.floor(bounds.getLayoutX()/60)*60+30, Math.ceil(bounds.getLayoutY()/60)*60+30, this.bombrange);
			root.getChildren().add(bomb.getUnitbox());
			bomb.startBomb(root,field);
		}else if(direction==2){
			bomb = new Bomb(Math.floor(bounds.getLayoutX()/60)*60+30, Math.floor(bounds.getLayoutY()/60)*60+30, this.bombrange);
			root.getChildren().add(bomb.getUnitbox());
			bomb.startBomb(root,field);
		}else if(direction==3){
			bomb = new Bomb(Math.ceil(bounds.getLayoutX()/60)*60+30, Math.ceil(bounds.getLayoutY()/60)*60+30, this.bombrange);
			root.getChildren().add(bomb.getUnitbox());
			bomb.startBomb(root,field);
		}		
//		bomb.setVisible(true);
//		this.bombList.add(bomb);

	}

	public List<Hitbox> getlhitbox() {
		return this.lhb;
	}

	public Hitbox getHerobox() {
		return this.bounds;
	}
	public List<Bomb> getbomblist(){
		return this.bombList;
	}
	protected abstract void update();

}
