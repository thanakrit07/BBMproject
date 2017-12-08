package Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	private Canvas s1;
	private GraphicsContext gc;
	private List<Hitbox> lh = new ArrayList<Hitbox>();

	public Stage1() {
		root = new Group();
		scene = new Scene(root, 1080, 920);
		s1 = new Canvas(1080, 920);
		gc = s1.getGraphicsContext2D();
		gc.setFill(Color.AQUAMARINE);
		gc.fillRect(0, 0, 1080, 960);
		root.getChildren().add(s1);
		s1.requestFocus();
		System.out.println("Create BG");
		
		
		// Create Hero
		Player1 p1 = new Player1(30, 30);
		Player2 p2 = new Player2(990, 870);

		//Create Border
		Hitbox bd1 = new Hitbox(0,0,1080,30);
		bd1.setFill(Color.SADDLEBROWN);
		Hitbox bd2 = new Hitbox(0,0,30,960);
		bd2.setFill(Color.SADDLEBROWN);
		Hitbox bd3 = new Hitbox(1050,0,30,960);
		bd3.setFill(Color.SADDLEBROWN);
		Hitbox bd4 = new Hitbox(0,930,1080,30);
		bd4.setFill(Color.SADDLEBROWN);
		
		List<Hitbox> lbd = new ArrayList<Hitbox>();
		lbd.add(bd1);
		lbd.add(bd2);
		lbd.add(bd3);
		lbd.add(bd4);
		
		p1.getlhitbox().addAll(lbd);
		
		p2.getlhitbox().addAll(lbd);
		
		root.getChildren().addAll(lbd);
		
		//add Hero
		root.getChildren().add(p1.getHerobox());
		root.getChildren().add(p2.getHerobox());
		System.out.println("Create Hero");
		
		// Create Wall
		
		int[][] field = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}};
		for(int i=0;i<14;i++) {
			for(int j=0;j<17;j++) {
				if (field[i][j]==1) {
//					System.out.println(""+(30+(j*60))+(30+(i+60)));
					Wall w =new Wall(30+(j*60),30+(i*60));
					p1.getlhitbox().add(w.getHitbox());
					p2.getlhitbox().add(w.getHitbox());
					root.getChildren().add(w.getHitbox());
					
				}
			}
		}		
		System.out.println("Create Wall");
		
		scene.setOnKeyPressed((KeyEvent event) -> {
			KeyInput.setKeyPressed(event.getCode(), true);
			System.out.println("Pressed");

		});

		scene.setOnKeyReleased((KeyEvent event) -> {
			KeyInput.setKeyPressed(event.getCode(), false);
		});

		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				p1.update();
				p2.update();
				update();
				
			}
		};
		animation.start();
	}
	
	public void update() {
		
	}

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.scene;

	}

}
