package item;

import entity.Hero;
import object.Gameobject;
import sharedObject.Hitbox;
import item.Item;

public class Stackbomb extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Stackbomb(double x, double y) {
		super(x, y);
		item = new Hitbox(x,y,60,60);
	}

	public void IsKeptBy(Hero hero) {
		if(!kept&&item.CollosionWith(hero.getHerobox())) {
			hero.increaseBombnumber();
			item.setVisible(false);
			kept = false;
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
