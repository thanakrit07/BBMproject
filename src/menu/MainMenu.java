package menu;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import scenemanager.SceneManager;
import sharedObject.AllScene;
import Map.GameScreen;

public class MainMenu implements AllScene {
	private Scene scene;
	private Group root;
	private Image startgame;
	private static final Font TITLE_FONT = new Font("Monospace", 80);
	private static final Font MENU_FONT = new Font("Monospace", 60);

	public MainMenu() {
		root = new Group();
		scene = new Scene(root, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		Canvas bg = new Canvas(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		GraphicsContext gc = bg.getGraphicsContext2D();
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillRect(0, 0, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		root.getChildren().add(bg);

		// load picture
		startgame = new Image(ClassLoader.getSystemResource("startgame.png").toString());
		gc.drawImage(startgame, 0, 0, 1080, 960);

		// write text
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFill(Color.WHITE);
		gc.setFont(MENU_FONT);
		gc.fillText("Press Enter to start", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT * 3 / 4);

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ENTER)) {
					GameScreen gs = new GameScreen(1080, 960);
					SceneManager.gotoSceneOf(gs.getScene());
					// GameMain.newGame();

				} else if (event.getCode().equals(KeyCode.ESCAPE)) {
					Platform.exit();
				}
			}
		});
	}

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.scene;
	}

	// private void addKeyEventHandler() {
	// //TODO Fill Cod
	// }

}
