import Map.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenemanager.SceneManager;

public class Main extends Application {
	public void start(Stage stage) {
		stage.setResizable(false);
		stage.sizeToScene();	
		SceneManager sm = new SceneManager(stage);
<<<<<<< HEAD
		sm.gotoMainMenu();
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
			}
		};
		animation.start();
		
		
||||||| merged common ancestors
		sm.gotoMainMenu();
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
//				gs.paintScreen();
//				gameLogic.logicUpdate();
//				RenderableHolder.getInstance().update();
			}
		};
		animation.start();
		
		
=======
		SceneManager.gotoMainMenu();		
>>>>>>> 961e98fbf3e2073150f43745be1d2cfd869d0245
	}

	public void stop(Stage stage) {

	}

	public static void main(String[] args) {
		launch(args);
	}
}
