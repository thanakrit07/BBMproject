package entity;

import input.KeyInput;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Player2 extends Hero{

	public Player2(double x, double y) {
		super(x, y);
		this.direction=1;
		this.bombrange=1;
		this.speed=3;
		this.alive=true;
		this.visble=true;
	}


	@Override
	public void update() {
		if (KeyInput.getKeyPressed(KeyCode.UP)) {
			this.direction=0;
			super.moveY();
			System.out.println("UP");
			
		}
		else if (KeyInput.getKeyPressed(KeyCode.DOWN)) {
			this.direction=2;
			super.moveY();
		
		}
		else if (KeyInput.getKeyPressed(KeyCode.LEFT)) {
			this.direction =3;
			super.moveX();
			
		}
		else if (KeyInput.getKeyPressed(KeyCode.RIGHT)) {
			this.direction =1;
			super.moveX();
			
		}
		

		if (KeyInput.getKeyPressed(KeyCode.ENTER)) {
			if (!KeyInput.setkeyPressed.contains(KeyCode.SPACE)) {
				DropBomb();
				KeyInput.setkeyPressed.add(KeyCode.SPACE);
			}
		}
		
	}


	@Override
	public void draw(GraphicsContext gc) {
		
		for (Bomb i : this.bombList) {
			if (i.isVisible()) {
//				i.drawEffectBomb(gc);
				i.draw(gc);
			}
		}
		gc.setFill(Color.BLUE);
		gc.fillOval(x, y, 60, 60);
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return this.visble;
	}


}
