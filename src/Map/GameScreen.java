package Map;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sharedObject.AllScene;
import sharedObject.ImageRef;
import scenemanager.SceneManager;

import java.util.ArrayList;
import java.util.List;

import Map.Stage1;

public class GameScreen implements AllScene {
	private Scene scene;
	private Group root;
	private List<AllScene> lscene;

	public GameScreen(double width, double height) {
		root = new Group();
		scene = new Scene(root, width, height);
		Canvas bg = new Canvas(width, height);
		GraphicsContext gc = bg.getGraphicsContext2D();
		gc.drawImage(ImageRef.getGamescreen(), 0, 0,width, height);
//		gc.setFill(Color.BLACK);
//		gc.fillRect(0, 0, width, height);
		root.getChildren().add(bg);
		
		// addInput();
		
		//Select Stage
		
		// add stage
		lscene = new ArrayList<AllScene>();
		Stage1 s1 = new Stage1();
		lscene.add(s1);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.DIGIT1)) {
					
					SceneManager.gotoSceneOf(s1.getScene());
					s1.AnimationStart();
				}
				else if(event.getCode().equals(KeyCode.ESCAPE)){
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
}
