package entity;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.Hitbox;
import entity.Bomb;
import input.KeyInput;

public class Player1 extends Hero{
	public Scene scene;
	public Player1(double x, double y) {
		super(x, y);
		this.direction=1;
		this.bombrange=1;
		this.speed=5;
		this.alive=true;
		bounds =new Hitbox(x,y,60,60);
		bounds.setFill(Color.BLUE);
		bounds.setVisible(alive);
		
	}

	public void update() {
		// TODO Auto-generated method stub
		System.out.println("P1 moving");
		if (KeyInput.getKeyPressed(KeyCode.W)) {			
			this.direction =0;
			moveY();
		}
		else if (KeyInput.getKeyPressed(KeyCode.D)) {
			this.direction =1;
			moveX();
		}
		else if (KeyInput.getKeyPressed(KeyCode.S)) {		
			this.direction =2;
			moveY();
		}
		else if (KeyInput.getKeyPressed(KeyCode.A)) {
			this.direction =3;
			moveX();
		}
		

		if (KeyInput.getKeyPressed(KeyCode.SPACE)) {
			if (!KeyInput.setkeyPressed.contains(KeyCode.SPACE)) {
				DropBomb();
				KeyInput.setkeyPressed.add(KeyCode.SPACE);
			}
		}

	}

}
