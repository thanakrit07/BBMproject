package scenemanager;

import Map.GameScreen;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import menu.MainMenu;

public class SceneManager {
	private static Stage primaryStage;
	private static Scene mainMenuScene;
	public static final int SCENE_WIDTH = 1080;
	public static final int SCENE_HEIGHT = 960;
	public SceneManager(Stage stage) {
		MainMenu mm= new MainMenu();
		mainMenuScene = mm.getScene();
		primaryStage = stage;
		primaryStage.setTitle("BBM");
		primaryStage.show();
	}

	public static void gotoMainMenu() {
		//TODO Fill Code
		primaryStage.setScene(mainMenuScene);
		
	}

	public static void gotoSceneOf(Scene scene) {
		//TODO Fill Code
		primaryStage.setScene(scene);
//		canvas.requestFocus();
	}
}
