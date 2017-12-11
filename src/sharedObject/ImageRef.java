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
		Image r1 = new Image(ClassLoader.getSystemResource("R_1.png").toString());
		Image r2 = new Image(ClassLoader.getSystemResource("R_2.png").toString());
		Image r3 = new Image(ClassLoader.getSystemResource("R_3.png").toString());
		Image r4 = new Image(ClassLoader.getSystemResource("R_4.png").toString());
		Image r5 = new Image(ClassLoader.getSystemResource("R_5.png").toString());
		Image r6 = new Image(ClassLoader.getSystemResource("R_6.png").toString());
		Image r7 = new Image(ClassLoader.getSystemResource("R_7.png").toString());
		Image r8 = new Image(ClassLoader.getSystemResource("R_8.png").toString());
		Image down1 = new Image(ClassLoader.getSystemResource("down1.png").toString());
		Image down2 = new Image(ClassLoader.getSystemResource("down2.png").toString());
		Image down3 = new Image(ClassLoader.getSystemResource("down3.png").toString());
		Image l1 = new Image(ClassLoader.getSystemResource("L_1.png").toString());
		Image l2 = new Image(ClassLoader.getSystemResource("L_2.png").toString());
		Image l3 = new Image(ClassLoader.getSystemResource("L_3.png").toString());
		Image l4 = new Image(ClassLoader.getSystemResource("L_4.png").toString());	
		Image l5 = new Image(ClassLoader.getSystemResource("L_5.png").toString());	
		Image l6 = new Image(ClassLoader.getSystemResource("L_6.png").toString());	
		Image l7 = new Image(ClassLoader.getSystemResource("L_7.png").toString());	
		Image l8 = new Image(ClassLoader.getSystemResource("L_8.png").toString());	
		WhiteBomber.add(up1);
		WhiteBomber.add(up2);
		WhiteBomber.add(up3);
		WhiteBomber.add(r1);
		WhiteBomber.add(r2);
		WhiteBomber.add(r3);
		WhiteBomber.add(r4);
		WhiteBomber.add(r5);
		WhiteBomber.add(r6);
		WhiteBomber.add(r7);
		WhiteBomber.add(r8);
		WhiteBomber.add(down1);
		WhiteBomber.add(down2);
		WhiteBomber.add(down3);
		WhiteBomber.add(l1);
		WhiteBomber.add(l2);
		WhiteBomber.add(l3);
		WhiteBomber.add(l4);
		WhiteBomber.add(l5);
		WhiteBomber.add(l6);
		WhiteBomber.add(l7);
		WhiteBomber.add(l8);
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

