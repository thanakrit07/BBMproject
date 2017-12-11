package envi;

import object.Gameobject;
import sharedObject.Hitbox;
public abstract class Envi implements Gameobject{
	protected Hitbox hitbox;
	protected double x,y;
	public Envi(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Hitbox getHitbox() {
		return hitbox;
	}
}
