package item;

import entity.Hero;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import object.Gameobject;
import sharedObject.Hitbox;

public class Boost extends Gameobject implements Item{
	private Hitbox item;
	private boolean kept = false;
	public Boost(double x,double y) {
		super(x,y);
		item = new Hitbox(x,y,60,60);
		item.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("boost.png").toString())));
	}
	
	public void IsKeptBy(Hero hero) {
		if(!kept&&item.CollosionWith(hero.getHerobox())) {
			hero.increaseSpeed();
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
}
