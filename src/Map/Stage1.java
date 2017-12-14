package Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import scenemanager.SceneManager;
import sharedObject.AllScene;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

import entity.Player1;
import entity.Player2;
import envi.Brick;
import envi.Wall;

import input.KeyInput;
import item.Item;
import sharedObject.Hitbox;
import sharedObject.ImageRef;

public class Stage1 implements AllScene {
	private Scene scene;
	private Group root;
	private Canvas s1;
	public static boolean isGameRunning;

	private static GraphicsContext gc;
	public static List<Brick> lbrick = new ArrayList<Brick>();
	public static List<Item> litem = new ArrayList<Item>();
	public static List<Hitbox> lbomb = new ArrayList<Hitbox>();
	private Player1 p1;
	private Player2 p2;
	public static int[][] field;
	private AnimationTimer animation;
	

	public Stage1() {
		root = new Group();
		scene = new Scene(root, 1080, 840);
		s1 = new Canvas(1080, 840);
		gc = s1.getGraphicsContext2D();
		gc.setFill(Color.SADDLEBROWN);
		gc.fillRect(0, 0, 1080, 840);
		
		gc.drawImage(ImageRef.getItemboardImage().get(3),0,720,1080,120);
		
		root.getChildren().add(s1);
		s1.requestFocus();
		System.out.println("Create BG");
		isGameRunning = true;

//---------------------------------------------- Create Hero-----------------------------------------------------
		p1 = new Player1(30, 30);
		p2 = new Player2(990, 630);

//---------------------------------------------- Create Border---------------------------------------------------
		Hitbox bd1 = new Hitbox(0, 0, 1080, 30);
		bd1.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("bordertop.png").toString())));
		Hitbox bd2 = new Hitbox(0, 30, 30, 690);
		bd2.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("borderleft.png").toString())));
		Hitbox bd3 = new Hitbox(1050, 30, 30, 690);
		bd3.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("borderright.png").toString())));
		Hitbox bd4 = new Hitbox(0, 690, 1080, 30);
		bd4.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("borderbot.png").toString())));
		
		List<Hitbox> lbd = new ArrayList<Hitbox>();
		lbd.add(bd1);
		lbd.add(bd2);
		lbd.add(bd3);
		lbd.add(bd4);

		p1.getlhitbox().addAll(lbd);
		p2.getlhitbox().addAll(lbd);
		root.getChildren().addAll(lbd);
// ---------------------------------------------------add Hero-----------------------------------------------------
		root.getChildren().add(p1.getHerobox());
		root.getChildren().add(p2.getHerobox());
		System.out.println("Create Hero");
		
// --------------------------------------------------Create Wall---------------------------------------------------

		field = new int[][] { { 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 0, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 },
				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 },
				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 },
				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 },
				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 0 },
				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0 },
//				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2, 1, 2 },
//				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 2 },
//				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2, 1, 2, 1, 2, 1, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 2, 2, 0, 0 } 
				};
		for (int i=0;i<11;i++) {
			for (int j=0;j<17;j++) {
				if (field[i][j]==2) {
					field[i][j] = ((int) Math.floor(Math.random() * 101)) % 2 * 2;
				}
			}
		}
		
		for (int i = 0; i < 11; i++) {
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
					lbrick.add(b);
					p1.getlhitbox().add(b.getHitbox());
					p2.getlhitbox().add(b.getHitbox());
					root.getChildren().add(b.getHitbox());
					
				}
			}
		}
		System.out.println("Create Wall");
//----------------------------------------------------addEventHandler-----------------------------------------
		scene.setOnKeyPressed((KeyEvent event) -> {
			if(event.getCode().equals(KeyCode.M)) {
				SceneManager.gotoSceneOf((new MainMenu()).getScene());
			}else if(event.getCode().equals(KeyCode.ESCAPE)){
				Platform.exit();
			}else {
				KeyInput.setKeyPressed(event.getCode(), true);				
			}


		});

		scene.setOnKeyReleased((KeyEvent event) -> {
			KeyInput.setKeyPressed(event.getCode(), false);
		});
//------------------------------------------------AnimationTimer------------------------------------------------
		animation = new AnimationTimer() {
			final long startNanoTime = System.nanoTime();

			public void handle(long currentNanoTime) {
				p1.update();
				p1.updateBomb(root, p1, p2);
				p2.update();
				p2.updateBomb(root, p1, p2);
				for (int i=litem.size()-1;i>=0;i--) {
					if (litem.get(i).getHitbox().CollosionWith(p1.getHerobox())) litem.get(i).IsKeptBy(p1);
					else if (litem.get(i).getHitbox().CollosionWith(p2.getHerobox())) litem.get(i).IsKeptBy(p2);
					if (litem.get(i).isKept()) litem.remove(i);
				}
				update();
				updateItem();
			}
		};
	}
	
//-----------------------------------------------------------------------------------------------------------------
	
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
				gc.fillText("3", 1080 / 2, 960 / 2);				
				Thread.sleep(1000);
				gc.setFill(Color.BLACK);
				gc.fillText("3", 1080 / 2, 960 / 2);
				gc.setFill(Color.WHITE);
				gc.fillText("2", 1080 / 2, 960 / 2);
				Thread.sleep(1000);
				gc.setFill(Color.BLACK);
				gc.fillText("2", 1080 / 2, 960 / 2);
				gc.setFill(Color.WHITE);
				gc.fillText("1", 1080 / 2, 960 / 2);
				Thread.sleep(1000);
				gc.setFill(Color.BLACK);
				gc.fillText("1", 1080 / 2, 960 / 2);
				gc.setFill(Color.WHITE);
				gc.fillText("START", 1080 / 2, 960 / 2);
				Thread.sleep(1000);
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
			isGameRunning=false;
			animation.stop();
			Canvas c = new Canvas(1080, 960);
			GraphicsContext gc = c.getGraphicsContext2D();
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, 1080, 960);
			c.setOpacity(0.8);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setFill(Color.WHITE);
			gc.setFont(new Font("Monoscpace", 40));
			gc.fillText("Go to Main Menu Press M\nExit Press Esc", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT * 3 / 4);
			gc.setFont(new Font("Monospace", 80));
			gc.fillText("GAME OVER", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT / 4);
			root.getChildren().add(c);
			if (!p1.isAlive() && p2.isAlive()) {
				gc.fillText("Player2 is the winner!!", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT / 2);
			} else if (p1.isAlive() && !p2.isAlive()) {
				gc.fillText("Player1 is the winner!!", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT / 2);
			} else if (!p1.isAlive() && !p2.isAlive()) {
				gc.fillText("You both dead :(", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT / 2);
			}
		}
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
	public void updateItem() {
		gc.clearRect(0, 720, 1080, 120);
		gc.drawImage(ImageRef.getItemboardImage().get(3),0,720,1080,120);
		gc.setFill(Color.WHITE);
		gc.setFont(new Font(45));
		gc.fillText(""+p1.getBombrange(), 230, 800);
		gc.fillText(""+p1.getCountBomb(), 325, 800);
		gc.fillText(""+p1.getCountboost(), 420, 800);
		gc.fillText(""+p2.getBombrange(), 735, 800);
		gc.fillText(""+p2.getCountBomb(), 835, 800);
		gc.fillText(""+p2.getCountboost(), 930, 800);
		s1.requestFocus();
	}

}
