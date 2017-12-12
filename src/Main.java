import Map.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenemanager.SceneManager;
import sharedObject.ImageRef;

public class Main extends Application {
	
	public void start(Stage stage) {
		ImageRef imref = new ImageRef();
		stage.setResizable(false);
		stage.sizeToScene();	
		SceneManager sm = new SceneManager(stage);				
		SceneManager.gotoMainMenu();

	SceneManager.gotoMainMenu();		
	}
	public void stop(Stage stage) {

	}

	public static void main(String[] args) {
		launch(args);
	}
}
