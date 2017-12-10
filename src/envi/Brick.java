package envi;

import sharedObject.Hitbox;

public class Brick extends Envi{
	private Hitbox hitbox;
	public Brick(double x,double y) {
		super(x,y);
		this.hitbox= new Hitbox(x,y,60,60);
		hitbox.setVisible(false);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
}
