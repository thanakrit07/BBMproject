package item;

import entity.Hero;
import sharedObject.Hitbox;
import sharedObject.ImageRef;

public class Upgradebomb extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Upgradebomb(double x, double y) {
		super(x, y);
		item = new Hitbox(x,y,60,60);
		item.setFill(ImageRef.getItemImage().get(2));
	}

	@Override
	public void IsKeptBy(Hero hero) {
		// TODO Auto-generated method stub
		if(!kept) {
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

	@Override
	public void setKept(boolean k) {
		// TODO Auto-generated method stub
		this.kept = k;
	}
}
