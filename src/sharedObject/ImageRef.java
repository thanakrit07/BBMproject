package sharedObject;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class ImageRef {
	private static List<Image> WhiteBomber = new ArrayList<Image>();
	private static List<Image> RedBomber = new ArrayList<Image>();
	private static List<Image> bomb1 =  new ArrayList<Image>();
//	public ImageRef(){
//		
//	}
	public static List<Image> getWhiteBomber(){
		Image u1 = new Image(ClassLoader.getSystemResource("U_1.png").toString());
		Image u2 = new Image(ClassLoader.getSystemResource("U_2.png").toString());
		Image u3 = new Image(ClassLoader.getSystemResource("U_3.png").toString());
		Image u4 = new Image(ClassLoader.getSystemResource("U_4.png").toString());
		Image r1 = new Image(ClassLoader.getSystemResource("R_1.png").toString());
		Image r2 = new Image(ClassLoader.getSystemResource("R_2.png").toString());
		Image r3 = new Image(ClassLoader.getSystemResource("R_3.png").toString());
		Image r4 = new Image(ClassLoader.getSystemResource("R_4.png").toString());
		Image d1 = new Image(ClassLoader.getSystemResource("D_1.png").toString());
		Image d2 = new Image(ClassLoader.getSystemResource("D_2.png").toString());
		Image d3 = new Image(ClassLoader.getSystemResource("D_3.png").toString());
		Image d4 = new Image(ClassLoader.getSystemResource("D_4.png").toString());
		Image l1 = new Image(ClassLoader.getSystemResource("L_1.png").toString());
		Image l2 = new Image(ClassLoader.getSystemResource("L_2.png").toString());
		Image l3 = new Image(ClassLoader.getSystemResource("L_3.png").toString());
		Image l4 = new Image(ClassLoader.getSystemResource("L_4.png").toString());	
		WhiteBomber.add(u1);
		WhiteBomber.add(u2);
		WhiteBomber.add(u3);
		WhiteBomber.add(u4);
		WhiteBomber.add(r1);
		WhiteBomber.add(r2);
		WhiteBomber.add(r3);
		WhiteBomber.add(r4);
		WhiteBomber.add(d1);
		WhiteBomber.add(d2);
		WhiteBomber.add(d3);
		WhiteBomber.add(d4);
		WhiteBomber.add(l1);
		WhiteBomber.add(l2);
		WhiteBomber.add(l3);
		WhiteBomber.add(l4);
		return WhiteBomber;
	}
	public static List<Image> getRedBomber(){
		Image u1 = new Image(ClassLoader.getSystemResource("RedU_1.png").toString());
		Image u2 = new Image(ClassLoader.getSystemResource("RedU_2.png").toString());
		Image u3 = new Image(ClassLoader.getSystemResource("RedU_3.png").toString());
		Image u4 = new Image(ClassLoader.getSystemResource("RedU_4.png").toString());
		Image r1 = new Image(ClassLoader.getSystemResource("RedR_1.png").toString());
		Image r2 = new Image(ClassLoader.getSystemResource("RedR_2.png").toString());
		Image r3 = new Image(ClassLoader.getSystemResource("RedR_3.png").toString());
		Image r4 = new Image(ClassLoader.getSystemResource("RedR_4.png").toString());
		Image d1 = new Image(ClassLoader.getSystemResource("RedD_1.png").toString());
		Image d2 = new Image(ClassLoader.getSystemResource("RedD_2.png").toString());
		Image d3 = new Image(ClassLoader.getSystemResource("RedD_3.png").toString());
		Image d4 = new Image(ClassLoader.getSystemResource("RedD_4.png").toString());
		Image l1 = new Image(ClassLoader.getSystemResource("RedL_1.png").toString());
		Image l2 = new Image(ClassLoader.getSystemResource("RedL_2.png").toString());
		Image l3 = new Image(ClassLoader.getSystemResource("RedL_3.png").toString());
		Image l4 = new Image(ClassLoader.getSystemResource("RedL_4.png").toString());	
		RedBomber.add(u1);
		RedBomber.add(u2);
		RedBomber.add(u3);
		RedBomber.add(u4);
		RedBomber.add(r1);
		RedBomber.add(r2);
		RedBomber.add(r3);
		RedBomber.add(r4);
		RedBomber.add(d1);
		RedBomber.add(d2);
		RedBomber.add(d3);
		RedBomber.add(d4);
		RedBomber.add(l1);
		RedBomber.add(l2);
		RedBomber.add(l3);
		RedBomber.add(l4);
		return RedBomber;
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

