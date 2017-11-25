package Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;

public class Stage1 implements IRenderable {

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.AQUAMARINE);
		gc.fillRect(0, 0, 1080, 920);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -9000;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
