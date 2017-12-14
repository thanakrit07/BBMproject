import javafx.application.Application;
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
	ImageRef.getSound().get(1).setVolume(0.3);
	ImageRef.getSound().get(1).play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
