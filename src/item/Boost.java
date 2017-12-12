package item;

import entity.Hero;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;
import object.Gameobject;
import sharedObject.Hitbox;

public class Boost extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Boost(double x,double y) {
		super(x,y);
		item = new Hitbox(x,y,60,60);
		item.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("boost.png").toString())));
	}
	
	@Override
	public void IsKeptBy(Hero hero) {
		if(!kept) {
			boolean collosion = false;
			Shape intersect = Shape.intersect(item,hero.getHerobox());
			double checkW = intersect.getBoundsInLocal().getWidth();
			double checkH = intersect.getBoundsInLocal().getHeight();
			if (checkW == 60 && checkH == 60) {
				collosion = true;	
			}
			if (collosion) {
				hero.increaseSpeed();
				item.setVisible(false);
				kept = true;				
			}
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
