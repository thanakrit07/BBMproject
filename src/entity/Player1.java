package entity;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.Hitbox;
import entity.Bomb;
import input.KeyInput;

public class Player1 extends Hero {

	public Player1(double x, double y) {
		super(x, y);
		this.direction = 1;
		this.bombrange = 1;
		this.speed = 5;
		this.alive = true;
		bounds = new Hitbox(x, y, 60, 60);
		bounds.setFill(Color.BLUE);
		bounds.setVisible(alive);
		
	}

	public void update() {
		// TODO Auto-generated method stub
		if (KeyInput.getKeyPressed(KeyCode.W)) {
			System.out.println("P1 moving");
			this.direction = 0;
			moveY();
		}
		if (KeyInput.getKeyPressed(KeyCode.D)) {
			System.out.println("P1 moving");
			this.direction = 1;
			moveX();
		}
		if (KeyInput.getKeyPressed(KeyCode.S)) {
			System.out.println("P1 moving");
			this.direction = 2;
			moveY();
		}
		if (KeyInput.getKeyPressed(KeyCode.A)) {
			System.out.println("P1 moving");
			this.direction = 3;
			moveX();
		}



	}
	public void updateBomb(Group root,int[][] field) {
		if (KeyInput.getKeyPressed(KeyCode.SPACE)) {
			System.out.println("P1 bomb");
			if (!KeyInput.setkeyPressed.contains(KeyCode.SPACE)) {
				DropBomb(root,field);			
				KeyInput.setkeyPressed.add(KeyCode.SPACE);
			}
		}
	}

}
