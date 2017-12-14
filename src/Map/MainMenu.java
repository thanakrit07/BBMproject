package Map;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import scenemanager.SceneManager;
import sharedObject.AllScene;
import sharedObject.ImageRef;

public class MainMenu implements AllScene {
	private Scene scene;
	private Group root;
	private Image startgame;
	private static final Font MENU_FONT = new Font("Monospace", 60);

	public MainMenu() {
		root = new Group();
		scene = new Scene(root, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		Canvas bg = new Canvas(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		GraphicsContext gc = bg.getGraphicsContext2D();
		root.getChildren().add(bg);

//-------------------------------startgame button-----------------------------------------------------------------
		Canvas st = new Canvas(400,90);
		st.setLayoutX(340);
		st.setLayoutY(720);
		st.getGraphicsContext2D().drawImage(ImageRef.getStartImage().get(0), 0,0 ,400,90);
		st.setOnMouseEntered(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event) {
				st.getGraphicsContext2D().drawImage(ImageRef.getStartImage().get(1), 0,0,400,90);
			}		
		});
		st.setOnMouseExited(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event) {
				st.getGraphicsContext2D().drawImage(ImageRef.getStartImage().get(0), 0,0,400,90);
			}		
		});
		st.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton()== MouseButton.PRIMARY) {
					GameScreen gs = new GameScreen(1080, 840);
					SceneManager.gotoSceneOf(gs.getScene());
				}
			}		
		});
		root.getChildren().add(st);
// --------------------------load picture----------------------------------------------------------------------------
		startgame = new Image(ClassLoader.getSystemResource("startgame.png").toString());
		gc.drawImage(startgame, 0, 0, 1080, 840);
//-------------------------------- write text-----------------------------------------------------------------------
//		gc.setTextAlign(TextAlignment.CENTER);
//		gc.setFill(Color.WHITE);
//		gc.setFont(MENU_FONT);
//		gc.fillText("Press Enter to start", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT * 3 / 4);
		
//		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//			public void handle(KeyEvent event) {
//				if (event.getCode().equals(KeyCode.ENTER)) {
//					GameScreen gs = new GameScreen(1080, 840);
//					SceneManager.gotoSceneOf(gs.getScene());
//
//				} else if (event.getCode().equals(KeyCode.ESCAPE)) {
//					Platform.exit();
//				}
//			}
//		});
	}

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.scene;
	}

}
