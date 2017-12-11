package item;

import entity.Hero;
import object.Gameobject;
import sharedObject.Hitbox;

public class Upgradebomb extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Upgradebomb(double x, double y) {
		super(x, y);
		item = new Hitbox(x,y,60,60);
	}

	@Override
	public void IsKeptBy(Hero hero) {
		// TODO Auto-generated method stub
		if(!kept&&item.CollosionWith(hero.getHerobox())) {
			hero.increaseBombrange();
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
