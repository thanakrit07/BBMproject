package item;

import entity.Hero;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import object.Gameobject;
import sharedObject.Hitbox;

public class Upgradebomb extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Upgradebomb(double x, double y) {
		super(x, y);
		item = new Hitbox(x,y,60,60);
		item.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("upgradebomb.png").toString())));
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
