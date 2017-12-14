package envi;

import Map.Stage1;
import item.Boost;
import item.Debomb;
import item.Deboost;
import item.Degradebomb;
import item.Item;
import item.Stackbomb;
import item.Upgradebomb;
import sharedObject.Hitbox;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Brick extends Envi {
	private Hitbox hitbox;

	public Brick(double x, double y) {
		super(x, y);
		this.hitbox = new Hitbox(x, y, 60, 60);
		hitbox.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("Brick.png").toString())));
		hitbox.setVisible(true);
	}

	public void destroyed(Group root) {
		this.hitbox.setVisible(false);
		int it = ((int) Math.floor(Math.random() * 202)) % 20;
		if (it == 1 || it == 7 || it == 10) {
			System.out.println("Stackbomb");
			Item item = new Stackbomb(hitbox.getBoundsInParent().getMinX(), hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());
			Stage1.litem.add(item);
		} else if (it == 2 || it == 8 || it == 11) {
			System.out.println("Upgradebomb");
			Item item = new Upgradebomb(hitbox.getBoundsInParent().getMinX(), hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());
			Stage1.litem.add(item);
		} else if (it == 3||it==9) {
			System.out.println("Boost");
			Item item = new Boost(hitbox.getBoundsInParent().getMinX(), hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());
			Stage1.litem.add(item);
		}else if(it==4) {
			System.out.println("Deboost");
			Item item = new Deboost(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());									
			Stage1.litem.add(item);
		}else if(it==5) {
			System.out.println("Debomb");
			Item item = new Debomb(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());									
			Stage1.litem.add(item);
		}else if(it==6) {
			System.out.println("Degradebomb");
			Item item = new Degradebomb(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());									
			Stage1.litem.add(item);
		}
		else
			System.out.println("None" + "");

	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return this.hitbox;
	}
}
