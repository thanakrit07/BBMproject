package scenemanager;

import Map.MainMenu;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	private static Stage primaryStage;
	private static Scene mainMenuScene;
	public static final int SCENE_WIDTH = 1080;
	public static final int SCENE_HEIGHT = 840;
	public SceneManager(Stage stage) {
		MainMenu mm= new MainMenu();
		mainMenuScene = mm.getScene();
		primaryStage = stage;
		primaryStage.setTitle("Bomber Man !!!");
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
