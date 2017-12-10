package Map;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.AllScene;
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
		
		
		// go to stage1
		//SceneManager.gotoSceneOf(s1.getScene());

	}

	public void addInput() {
		// this.setOnKeyPressed((KeyEvent event) -> {
		// System.out.println("pressed");
		// KeyInput.setKeyPressed(event.getCode(), true);
		//
		// });
		// this.setOnKeyReleased((KeyEvent event) -> {
		// System.out.println("Released");
		// KeyInput.setKeyPressed(event.getCode(), false);
		// });

	}

	// public void paintScreen() {
	//
	// GraphicsContext gc = this.getGraphicsContext2D();
	//// for (IRenderable object : RenderableHolder.getInstance().getListhitbox()) {
	//// // System.out.println(entity.getZ());
	////
	//// if (object.isVisible()) {
	//// object.draw(gc);
	//// }
	//// }
	// gc.setStroke(Color.BLACK);
	// gc.strokeRect(0, 0, 1080, 920);
	// gc.setLineWidth(20);
	// }

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.scene;
	}
}
