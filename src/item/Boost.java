package item;

import entity.Hero;
import javafx.scene.shape.Shape;
import sharedObject.Hitbox;
import sharedObject.ImageRef;

public class Boost extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Boost(double x,double y) {
		super(x,y);
		item = new Hitbox(x,y,60,60);
		item.setFill(ImageRef.getItemImage().get(0));
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
				hero.setCountboost(hero.getCountboost()+1);
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

	@Override
	public void setKept(boolean k) {
		// TODO Auto-generated method stub
		this.kept = k;
	}
}
