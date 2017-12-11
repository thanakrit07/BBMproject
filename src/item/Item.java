package item;

import entity.Hero;
import sharedObject.Hitbox;

public interface Item {
	public void IsKeptBy(Hero hero) ;
	public Hitbox getHitbox();
	public boolean isKept();
}
