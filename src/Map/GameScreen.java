package Map;

import input.KeyInput;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameScreen extends Canvas{
	public GameScreen(double width, double height) {
		super(width, height);
		addInput();
	}
	public void addInput() {
		this.setOnKeyPressed((KeyEvent event) -> {
			System.out.println("pressed");
			KeyInput.setKeyPressed(event.getCode(), true);

		});
		this.setOnKeyReleased((KeyEvent event) -> {
			System.out.println("Released");
			KeyInput.setKeyPressed(event.getCode(), false);
		});

	}
	
	public void paintScreen() {
		
		GraphicsContext gc = this.getGraphicsContext2D();
		for (IRenderable object : RenderableHolder.getInstance().getListhitbox()) {
			// System.out.println(entity.getZ());

			if (object.isVisible()) {
				object.draw(gc);
			}
			
			
		}
		gc.setStroke(Color.BLACK);
		gc.strokeRect(0, 0, 1080, 920);
		gc.setLineWidth(20);
	}
}
