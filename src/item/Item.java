package item;

import entity.Hero;
import sharedObject.Hitbox;
import object.Gameobject;

public abstract class Item implements Gameobject {
	protected double x,y;
	
	public Item(double x, double y) {
		this.x = x;
		this.y= y;
	}
	
	public abstract void IsKeptBy(Hero hero) ;
	public abstract Hitbox getHitbox();
	public abstract boolean isKept();
}
