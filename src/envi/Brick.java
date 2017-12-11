package envi;

import com.sun.prism.paint.Color;

import Map.Stage1;
import item.Boost;
import item.Item;
import item.Stackbomb;
import item.Upgradebomb;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import sharedObject.Hitbox;
import javafx.scene.Group;

public class Brick extends Envi{
	private Hitbox hitbox;
	public Brick(double x,double y) {
		super(x,y);
		this.hitbox= new Hitbox(x,y,60,60);
		hitbox.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("Brick.png").toString())));
		hitbox.setVisible(true);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}	
	public void destroyed(Group root) {
		this.hitbox.setVisible(false);
		int it = (int) Math.floor(Math.random() * 10);
			System.out.println("Stackbomb");
		if (it==1||it==5||it==9||it==3) {	
			Item item = new Stackbomb(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());
			Stage1.getItemList().add(item);
		}else if (it==2||it==6||it==10||it==4) {
			System.out.println("Upgradebomb");
			Item item = new Upgradebomb(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
			item.getHitbox().setVisible(true);
			root.getChildren().add(item.getHitbox());
			Stage1.getItemList().add(item);
		}
//		else if (it==0||it==4||it==8) {
//			System.out.println("Boost");
//			Item item = new Boost(hitbox.getBoundsInParent().getMinX(),hitbox.getBoundsInParent().getMinY());
//			item.getHitbox().setVisible(true);
//			root.getChildren().add(item.getHitbox());									
//			Stage1.getItemList().add(item);
//		} 
		else System.out.println("None"+ "");
	}
}
