package item;

import entity.Hero;
import object.Gameobject;
import sharedObject.Hitbox;
import sharedObject.ImageRef;
import item.Item;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Stackbomb extends Item{
	private Hitbox item;
	private boolean kept = false;
	public Stackbomb(double x, double y) {
		super(x, y);
		item = new Hitbox(x,y,60,60);
		item.setFill(ImageRef.getItem().get(4));
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
}
