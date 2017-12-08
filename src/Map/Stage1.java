package Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import sharedObject.AllScene;
import javafx.animation.AnimationTimer;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

import entity.Player1;
import entity.Player2;
import envi.Wall;

import input.KeyInput;
import sharedObject.Hitbox;

public class Stage1 implements AllScene {
	private Scene scene;
	private Group root;
	private List<Hitbox> lh = new ArrayList<Hitbox>();

	public Stage1() {
		root = new Group();
		scene = new Scene(root, 1080, 920);
		Canvas s1 = new Canvas(1080, 920);
		GraphicsContext gc = s1.getGraphicsContext2D();
		gc.setFill(Color.AQUAMARINE);
		gc.fillRect(0, 0, 1080, 920);
		root.getChildren().add(s1);
		s1.requestFocus();
		System.out.println("Create BG");

		// Create Hero
		Player1 p1 = new Player1(50, 50);
		Player2 p2 = new Player2(960, 800);
		root.getChildren().add(p1.getHerobox());
		root.getChildren().add(p2.getHerobox());
		System.out.println("Create Hero");

		// Create Wall
		Wall w1 = new Wall(500, 500);
		lh.add(w1.getHitbox());
		p1.getlhitbox().addAll(lh);
		p2.getlhitbox().addAll(lh);
		root.getChildren().addAll(lh);
		System.out.println("Create Wall");

		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				p1.update();
				p2.update();
			}
		};
		animation.start();
		
		scene.setOnKeyPressed((KeyEvent event) -> {
			KeyInput.setKeyPressed(event.getCode(), true);
			System.out.println("Pressed");

		});

		scene.setOnKeyReleased((KeyEvent event) -> {
			KeyInput.setKeyPressed(event.getCode(), false);
		});

	}

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.scene;

	}

}
