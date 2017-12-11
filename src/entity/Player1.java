package entity;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import sharedObject.Hitbox;
import sharedObject.ImageRef;

import java.util.List;

import com.sun.scenario.effect.ImageData;

import entity.Bomb;
import envi.Envi;
import input.KeyInput;

public class Player1 extends Hero {
//	protected static int countBomb = 3;
	protected static boolean alive;
//	private ImageRef imref ;
	private AnimationTimer animationwalk;
	public Player1(double x, double y) {
		super(x, y);
		this.direction = 1;
		this.bombrange = 1;
		this.speed = 5;
		this.alive = true;

		bounds = new Hitbox(x, y, 60, 60);
		bounds.setFill(Color.BLUE);
		bounds.setVisible(alive);		
//		imref = new ImageRef();
		bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(1+3)));
		animationwalk = new AnimationTimer(){
			final long startNanoTime = System.nanoTime();
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0) % 0.45;
				int ck=0;
				if(direction==0)ck=0;
				else if(direction==1)ck=3;
				else if(direction==2)ck=6;
				else if(direction==3)ck=9;
				
				if(t>0 && t<=0.15) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(0+ck)));
				
				}else if(t>0.15 && t<=0.3) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(1+ck)));
				}else if(t>0.3 && t<=0.45) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(2+ck)));
				}				
			}			
		};
		
	}
	public void update() {
		// TODO Auto-generated method stub
		if (KeyInput.getKeyPressed(KeyCode.W)) {
			animationwalk.start();
			this.direction = 0;
			moveY();
		}
		if (KeyInput.getKeyPressed(KeyCode.D)) {
			animationwalk.start();
			this.direction = 1;
			moveX();
		}
		if (KeyInput.getKeyPressed(KeyCode.S)) {
			animationwalk.start();
			this.direction = 2;
			moveY();
		}
		if (KeyInput.getKeyPressed(KeyCode.A)) {
			animationwalk.start();
			this.direction = 3;
			moveX();
		}
		if(KeyInput.keyPressed.isEmpty())animationwalk.stop();;		
	}

	public void updateBomb(Group root, int[][] field,Player1 p1,Player2 p2,List<Envi> listenvi) {
		if (KeyInput.getKeyPressed(KeyCode.SPACE)) {
//			System.out.println("P1 bomb");
			if (!KeyInput.setkeyPressed.contains(KeyCode.SPACE)) {
				if (countBomb>0) {
					DropBomb(root, field,p1,p2,listenvi);					
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
				KeyInput.setkeyPressed.add(KeyCode.SPACE);
			}
		}
	}
	public static void setDead() {
		alive = false;
	}
	public Hitbox getHerobox() {
		return this.bounds;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return this.alive;
	}

}
