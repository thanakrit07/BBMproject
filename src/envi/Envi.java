package envi;

import object.Gameobject;
import sharedObject.Hitbox;
public abstract class Envi extends Gameobject{
	private Hitbox hitbox;
	public Envi(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	protected boolean destroyed;
	public Hitbox getHitbox() {
		return hitbox;
	}
}
