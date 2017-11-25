import Map.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sharedObject.GameLogic;
import sharedObject.RenderableHolder;

public class Main extends Application {
	public void start(Stage stage) {
		Group root = new Group();
		
		GameScreen gs = new GameScreen(1080, 920);
		GameLogic gameLogic=new GameLogic();
		
		Scene scene = new Scene(root);
		root.getChildren().add(gs);
		gs.requestFocus();

		stage.setScene(scene);
		stage.setTitle("BBM");
		stage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gs.paintScreen();
				gameLogic.logicUpdate();
				RenderableHolder.getInstance().update();
				
				
			}
		};
		animation.start();
		
		
	}

	public void stop(Stage stage) {

	}

	public static void main(String[] args) {
		launch(args);
	}
}
