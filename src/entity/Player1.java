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

import Map.Stage1;
import entity.Bomb;
import envi.Envi;
import input.KeyInput;
import item.Item;

public class Player1 extends Hero {
//	protected static int countBomb = 3;
	protected static boolean alive;
//	private ImageRef imref ;
	private AnimationTimer animationwalk;
	public Player1(double x, double y) {
		super(x, y);
		this.direction = 1;
		this.bombrange = 1;
		this.speed = 3;
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
				else if(direction==2)ck=11;
				else if(direction==3)ck=14;
				
				if(t>0 && t<=0.1) {					
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(0+ck)));
				
				}else if(t>0.1 && t<=0.2) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(1+ck)));
				}else if(t>0.2 && t<=0.3) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(2+ck)));
				}else if(t>0.3 && t<=0.4) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(3+ck)));
				}else if(t>0.4 && t<=0.5) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(4+ck)));
				}else if(t>0.5 && t<=0.6) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(5+ck)));
				}else if(t>0.6 && t<=0.7) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(6+ck)));
				}else if(t>0.7 && t<=0.8) {
					bounds.setFill(new ImagePattern(ImageRef.getWhiteBomber().get(7+ck)));
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
		if(KeyInput.keyPressed.isEmpty())animationwalk.stop();		
	}
	public void updateBomb(Group root, Player1 p1, Player2 p2) {
		if (KeyInput.getKeyPressed(KeyCode.SPACE)) {
//			System.out.println("P1 bomb");
			if (!KeyInput.setkeyPressed.contains(KeyCode.SPACE)) {
				if (countBomb>0) {
					DropBomb(root,p1,p2);					

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
