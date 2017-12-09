package entity;

import javafx.scene.Group;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.Hitbox;

import java.util.List;

import entity.Bomb;
import input.KeyInput;

public class Player2 extends Hero {
	protected static int countBomb = 3;
	protected static boolean alive;

	public Player2(double x, double y) {
		super(x, y);
		this.direction = 3;
		this.bombrange = 1;
		this.speed = 5;
		this.alive = true;

		bounds = new Hitbox(x, y, 60, 60);
		bounds.setFill(Color.AQUA);
		bounds.setVisible(alive);
	}

	public void update() {
		// TODO Auto-generated method stub
		if (KeyInput.getKeyPressed(KeyCode.UP)) {
			this.direction = 0;
			moveY();
		}
		if (KeyInput.getKeyPressed(KeyCode.RIGHT)) {

			this.direction = 1;
			moveX();
		}
		if (KeyInput.getKeyPressed(KeyCode.DOWN)) {
			this.direction = 2;
			moveY();
		}
		if (KeyInput.getKeyPressed(KeyCode.LEFT)) {
			this.direction = 3;
			moveX();
		}
	}

	public void updateBomb(Group root, int[][] field,Player1 p1,Player2 p2) {
		if (KeyInput.getKeyPressed(KeyCode.ENTER)) {
//			System.out.println("P2 bomb");
			if (!KeyInput.setkeyPressed.contains(KeyCode.ENTER)) {
				if (countBomb>0) {
					DropBomb(root, field,p1,p2);					
					Thread thread = new Thread(() -> {
						countBomb--;
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						countBomb++;
					});
					thread.start();
				}
				KeyInput.setkeyPressed.add(KeyCode.ENTER);
			}
		}
	}
	public static void setDead() {
		alive = false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return this.alive;
	}

}
