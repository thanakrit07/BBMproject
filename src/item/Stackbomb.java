package item;

import entity.Hero;
import object.Gameobject;
import sharedObject.Hitbox;

public class Stackbomb extends Gameobject implements Item{
	private Hitbox item;
	private boolean kept = false;
	public Stackbomb(double x, double y) {
		super(x, y);
		item = new Hitbox(x,y,60,60);
	}

	@Override
	public void IsKeptBy(Hero hero) {
		if(!kept&&item.CollosionWith(hero.getHerobox())) {
			hero.increaseBombnumber();
			item.setVisible(false);
			kept = false;
		}
		
	}
	
	public Hitbox getHitbox() {
		return item;
	}
	
	public boolean isKept() {
		return kept;
	}
}
