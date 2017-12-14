package item;

import entity.Hero;
import sharedObject.Hitbox;
import sharedObject.ImageRef;
import item.Item;

public class Stackbomb extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Stackbomb(double x, double y) {
		super(x, y);
		item = new Hitbox(x,y,60,60);
		item.setFill(ImageRef.getItemImage().get(4));
	}

	public void IsKeptBy(Hero hero) {
		if(!kept) {
			hero.increaseBombnumber();
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
