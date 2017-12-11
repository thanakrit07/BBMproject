package envi;

import Map.Stage1;
import item.Boost;
import item.Item;
import item.Stackbomb;
import item.Upgradebomb;
import sharedObject.Hitbox;
import javafx.scene.Group;

public class Brick extends Envi{
	private Hitbox hitbox;
	public Brick(double x,double y) {
		super(x,y);
		this.hitbox= new Hitbox(x,y,60,60);
		hitbox.setVisible(true);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}	
	public void destroyed(Group root) {
		this.hitbox.setVisible(false);
		int it = (int) Math.floor(Math.random() * 4);
		if (it==0) {
			System.out.println("Boost");
			Item item = new Boost(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());									
			Stage1.getItemList().add(item);
		}else if (it==1) {
			System.out.println("Stackbomb");
			Item item = new Stackbomb(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());
			Stage1.getItemList().add(item);
		}else if (it==2) {
			System.out.println("Upgradebomb");
			Item item = new Upgradebomb(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());
			Stage1.getItemList().add(item);
		}else System.out.println("None");
	}
}
