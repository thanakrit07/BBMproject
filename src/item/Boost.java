package item;

import entity.Hero;
import object.Gameobject;
import sharedObject.Hitbox;

public class Boost extends Item{
	private Hitbox item;
	private boolean kept = false;
	
	public Boost(double x,double y) {
		super(x,y);
		item = new Hitbox(x,y,60,60);
	}
	
	@Override
	public void IsKeptBy(Hero hero) {
		if(!kept) {
			hero.increaseSpeed();
			item.setVisible(false);
			kept = true;
		}
	}

	@Override
	public Hitbox getHitbox() {
		return item;
	}
	
	@Override
	public boolean isKept() {
		return kept;
	}
}
