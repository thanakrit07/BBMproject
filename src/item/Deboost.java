package item;

import entity.Hero;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;
import sharedObject.Hitbox;
import sharedObject.ImageRef;

public class Deboost extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Deboost(double x,double y) {
		super(x,y);
		item = new Hitbox(x,y,60,60);
		item.setFill(ImageRef.getItem().get(1));
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
				hero.decreaseSpeed();
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
