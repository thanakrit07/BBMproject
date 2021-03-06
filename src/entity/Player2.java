package entity;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;

import javafx.scene.input.KeyCode;
import sharedObject.Hitbox;
import sharedObject.ImageRef;
import Map.Stage1;
import input.KeyInput;

public class Player2 extends Hero {
	protected static boolean alive;
	private AnimationTimer animationwalk;

	public Player2(double x, double y) {
		super(x, y);
		this.setDirection(3);
		this.bombrange = 1;
		this.countBomb = 1;
		this.countboost = 1;
		speed = 3;
		alive = true;

		bounds = new Hitbox(x, y, 60, 60);
		bounds.setVisible(alive);
		bounds.setFill(ImageRef.getRedBomberImage().get(1 + 12));

		animationwalk = new AnimationTimer() {
			final long startNanoTime = System.nanoTime();

			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0) % 0.60;
				int ck = 0;
				if (getDirection() == 0)
					ck = 0;
				else if (getDirection() == 1)
					ck = 4;
				else if (getDirection() == 2)
					ck = 8;
				else if (getDirection() == 3)
					ck = 12;

				if (t > 0 && t <= 0.15) {
					bounds.setFill(ImageRef.getRedBomberImage().get(0 + ck));
				} else if (t > 0.15 && t <= 0.30) {
					bounds.setFill(ImageRef.getRedBomberImage().get(1 + ck));
				} else if (t > 0.30 && t <= 0.45) {
					bounds.setFill(ImageRef.getRedBomberImage().get(2 + ck));
				} else if (t > 0.45 && t <= 0.60) {
					bounds.setFill(ImageRef.getRedBomberImage().get(3 + ck));
				}
			}
		};
	}

	public void update() {
		// TODO Auto-generated method stub
		if (KeyInput.getKeyPressed(KeyCode.UP)) {
			animationwalk.start();
			this.setDirection(0);
			moveY();
		}
		if (KeyInput.getKeyPressed(KeyCode.RIGHT)) {
			animationwalk.start();
			this.setDirection(1);
			moveX();
		}
		if (KeyInput.getKeyPressed(KeyCode.DOWN)) {
			animationwalk.start();
			this.setDirection(2);
			moveY();
		}
		if (KeyInput.getKeyPressed(KeyCode.LEFT)) {
			animationwalk.start();
			this.setDirection(3);
			moveX();
		}
		if (KeyInput.keyPressed.isEmpty())
			animationwalk.stop();
	}

	public void updateBomb(Group root, Player1 p1, Player2 p2) {

		if (KeyInput.getKeyPressed(KeyCode.ENTER)) {
			if (!KeyInput.setkeyPressed.contains(KeyCode.ENTER)) {
				if (countBomb > 0) {
					DropBomb(root, p1, p2);

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

		try {
			for (int i=0;i<Stage1.lbomb.size();i++) {
				if (!Stage1.lbomb.get(i).getHitbox().CollisionWith(bounds)&&!this.lhb.contains(Stage1.lbomb.get(i).getHitbox())) {
					this.lhb.add(Stage1.lbomb.get(i).getHitbox());				
				}
			}			
		}catch (IndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}

	}

	public static void setDead() {
		alive = false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return alive;
	}

}
