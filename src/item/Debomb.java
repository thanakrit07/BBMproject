package item;

import entity.Hero;
import sharedObject.Hitbox;
import sharedObject.ImageRef;

public class Debomb extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Debomb(double x, double y) {
		super(x, y);
		item = new Hitbox(x,y,60,60);
		item.setFill(ImageRef.getItem().get(5));
	}

	public void IsKeptBy(Hero hero) {
		if(!kept&&item.CollosionWith(hero.getHerobox())) {
			hero.decreaseBombnumber();
			item.setVisible(false);
			kept = true;
		}
		
	}
	
	public Hitbox getHitbox() {
		return item;
	}
	
	public boolean isKept() {
		return kept;
	}

	@Override
	public void setKept(boolean k) {
		// TODO Auto-generated method stub
		this.kept = k;
	}	
}
