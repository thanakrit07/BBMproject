package Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sharedObject.AllScene;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

import entity.Player1;
import entity.Player2;
import envi.Envi;
import envi.Brick;
import envi.Wall;

import input.KeyInput;
import sharedObject.Hitbox;

public class Stage1 implements AllScene {
	private Scene scene;
	private Group root;
	private Canvas s1;

	private static GraphicsContext gc;
	public static List<Hitbox> lbrick = new ArrayList<Hitbox>();
	private Player1 p1;
	private Player2 p2;
	public static int[][] field;
	private AnimationTimer animation;

	public Stage1() {
		root = new Group();
		scene = new Scene(root, 1080, 960);
		s1 = new Canvas(1080, 960);
		gc = s1.getGraphicsContext2D();
		gc.setFill(Color.AQUAMARINE);
		gc.fillRect(0, 0, 1080, 960);
		root.getChildren().add(s1);
		s1.requestFocus();
		System.out.println("Create BG");

		// Create Hero
		p1 = new Player1(30, 30);
		p2 = new Player2(990, 870);

		// Create Border
		Hitbox bd1 = new Hitbox(0, 0, 1080, 30);
		bd1.setFill(Color.SADDLEBROWN);
		Hitbox bd2 = new Hitbox(0, 0, 30, 960);
		bd2.setFill(Color.SADDLEBROWN);
		Hitbox bd3 = new Hitbox(1050, 0, 30, 960);
		bd3.setFill(Color.SADDLEBROWN);
		Hitbox bd4 = new Hitbox(0, 930, 1080, 30);
		bd4.setFill(Color.SADDLEBROWN);

		List<Hitbox> lbd = new ArrayList<Hitbox>();
		lbd.add(bd1);
		lbd.add(bd2);
		lbd.add(bd3);
		lbd.add(bd4);

		p1.getlhitbox().addAll(lbd);
		p2.getlhitbox().addAll(lbd);
		root.getChildren().addAll(lbd);

		// add Hero
		root.getChildren().add(p1.getHerobox());
		root.getChildren().add(p2.getHerobox());
		System.out.println("Create Hero");

		// Create Wall

		field = new int[][] { { 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
				{ 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 2, 1, 0, 1, 0, 1, 0, 1, 2, 1, 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 17; j++) {
				if (field[i][j] == 1) {
					Wall w = new Wall(30 + (j * 60), 30 + (i * 60));
					p1.getlhitbox().add(w.getHitbox());
					p2.getlhitbox().add(w.getHitbox());
					root.getChildren().add(w.getHitbox());
				} else if (field[i][j] == 0 && (i + j) % 2 == 0) {
					Image floor = new Image(ClassLoader.getSystemResource("floor1.png").toString());
					gc.drawImage(floor, 30 + (j * 60), 30 + (i * 60), 60, 60);
				} else if (field[i][j] == 0 && (i + j) % 2 == 1) {
					Image floor = new Image(ClassLoader.getSystemResource("floor2.png").toString());
					gc.drawImage(floor, 30 + (j * 60), 30 + (i * 60), 60, 60);
				} else if (field[i][j] == 2) {
					Brick b = new Brick(30 + (j* 60), 30 + (i * 60));
					lbrick.add(b.getHitbox());
					p1.getlhitbox().add(b.getHitbox());
					p2.getlhitbox().add(b.getHitbox());
					root.getChildren().add(b.getHitbox());
					
				}
			}
		}
		System.out.println("Create Wall");

		scene.setOnKeyPressed((KeyEvent event) -> {
			KeyInput.setKeyPressed(event.getCode(), true);
			// System.out.println("Pressed");

		});

		scene.setOnKeyReleased((KeyEvent event) -> {
			KeyInput.setKeyPressed(event.getCode(), false);
		});

		animation = new AnimationTimer() {
			final long startNanoTime = System.nanoTime();

			public void handle(long currentNanoTime) {
				p1.update();
				p1.updateBomb(root, field, lbrick, p1, p2);
				p2.update();
				p2.updateBomb(root, field, lbrick, p1, p2);

				update();
			}
		};
	}

	public void AnimationStart() {
		new Thread(() -> {
			Canvas cs = new Canvas(1080, 960);
			GraphicsContext gc = cs.getGraphicsContext2D();
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, 1080, 960);
			cs.setOpacity(0.8);
			gc.setFill(Color.WHITE);
			gc.setStroke(Color.BLACK);
			gc.setFont(new Font("Monospace", 200));
			gc.setTextAlign(TextAlignment.CENTER);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					root.getChildren().add(cs);
				}
				
			});
			try {
				gc.fillText("1", 1080 / 2, 960 / 2);				
				Thread.sleep(1000);
				gc.setFill(Color.BLACK);
				gc.fillText("1", 1080 / 2, 960 / 2);
				gc.setFill(Color.WHITE);
				gc.fillText("2", 1080 / 2, 960 / 2);
				Thread.sleep(1000);
				gc.setFill(Color.BLACK);
				gc.fillText("2", 1080 / 2, 960 / 2);
				gc.setFill(Color.WHITE);
				gc.fillText("3", 1080 / 2, 960 / 2);
				Thread.sleep(1000);
				gc.setFill(Color.BLACK);
				gc.fillText("3", 1080 / 2, 960 / 2);
				gc.setFill(Color.WHITE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					root.getChildren().remove(cs);
				}
				
			});
			this.animation.start();
		}).start();
		
	}

	public void update() {
		if (!p1.isAlive() || !p2.isAlive()) {
			animation.stop();
			Canvas c = new Canvas(1080, 960);
			GraphicsContext gc = c.getGraphicsContext2D();
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, 1080, 960);
			c.setOpacity(0.8);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setFill(Color.WHITE);
			gc.setFont(new Font("Monospace", 80));
			// gc.fillText("Game End", 500, 500);
			root.getChildren().add(c);
			if (!p1.isAlive() && p2.isAlive()) {
				gc.fillText("Player2 is the winner!!", 1080 / 2, 960 / 2);
			} else if (p1.isAlive() && !p2.isAlive()) {
				gc.fillText("Player1 is the winner!!", 1080 / 2, 960 / 2);
			} else if (!p1.isAlive() && !p2.isAlive()) {
				gc.fillText("You both dead :(", 1080 / 2, 960 / 2);
			}
		}
	}
	
	public static List<Hitbox> getBrick(){
		return lbrick;
	}
	
	public static void drawFloor(int i, int j) {
		if ((i + j) % 2 == 0) {
			Image floor = new Image(ClassLoader.getSystemResource("floor1.png").toString());
			gc.drawImage(floor, 30 + (j * 60), 30 + (i * 60), 60, 60);
		} else {
			Image floor = new Image(ClassLoader.getSystemResource("floor2.png").toString());
			gc.drawImage(floor, 30 + (j * 60), 30 + (i * 60), 60, 60);
		}
	}

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.scene;

	}

}
