package item;

import entity.Hero;
import object.Gameobject;
import sharedObject.Hitbox;

public class Boost extends Gameobject implements Item{
	private Hitbox item;
	
	public Boost(double x,double y) {
		super(x,y);
		item = new Hitbox(x,y,60,60);
	}
	
	public void IsKeptBy(Hero hero) {
		if(item.CollosionWith(hero.getHerobox())) {
			hero.increaseSpeed();
			item.setVisible(false);
		}
	}
}
