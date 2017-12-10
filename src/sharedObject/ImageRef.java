package sharedObject;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class ImageRef {
	private static List<Image> WhiteBomber = new ArrayList<Image>();
	private static List<Image> bomb1 =  new ArrayList<Image>();
//	public ImageRef(){
//		
//	}
	public static List<Image> getWhiteBomber(){
		Image up1 = new Image(ClassLoader.getSystemResource("forward1.png").toString());
		Image up2 = new Image(ClassLoader.getSystemResource("forward2.png").toString());
		Image up3 = new Image(ClassLoader.getSystemResource("forward3.png").toString());
		Image right1 = new Image(ClassLoader.getSystemResource("right1.png").toString());
		Image right2 = new Image(ClassLoader.getSystemResource("right2.png").toString());
		Image right3 = new Image(ClassLoader.getSystemResource("right3.png").toString());
		Image down1 = new Image(ClassLoader.getSystemResource("down1.png").toString());
		Image down2 = new Image(ClassLoader.getSystemResource("down2.png").toString());
		Image down3 = new Image(ClassLoader.getSystemResource("down3.png").toString());
		Image left1 = new Image(ClassLoader.getSystemResource("left1.png").toString());
		Image left2 = new Image(ClassLoader.getSystemResource("left2.png").toString());
		Image left3 = new Image(ClassLoader.getSystemResource("left3.png").toString());		
		WhiteBomber.add(up1);
		WhiteBomber.add(up2);
		WhiteBomber.add(up3);
		WhiteBomber.add(right1);
		WhiteBomber.add(right2);
		WhiteBomber.add(right3);
		WhiteBomber.add(down1);
		WhiteBomber.add(down2);
		WhiteBomber.add(down3);
		WhiteBomber.add(left1);
		WhiteBomber.add(left2);
		WhiteBomber.add(left3);
		return WhiteBomber;
	}
	public static List<Image> getBomb1(){
		Image b1 = new Image(ClassLoader.getSystemResource("bomb1_1.png").toString());
		Image b2 = new Image(ClassLoader.getSystemResource("bomb1_2.png").toString());
		Image b3 = new Image(ClassLoader.getSystemResource("bomb1_3.png").toString());
		Image b4 = new Image(ClassLoader.getSystemResource("efbomb1.png").toString());
		bomb1.add(b1);
		bomb1.add(b2);
		bomb1.add(b3);
		bomb1.add(b4);
		return bomb1;
	}
}
