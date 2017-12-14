package sharedObject;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;

public class ImageRef {
	private static List<ImagePattern> WhiteBomber = new ArrayList<ImagePattern>();
	private static List<ImagePattern> RedBomber = new ArrayList<ImagePattern>();
	private static List<ImagePattern> bomb1 = new ArrayList<ImagePattern>();
	private static List<ImagePattern> item = new ArrayList<ImagePattern>();
	private static List<Image> itemboard = new ArrayList<Image>();
	private static List<Image> start = new ArrayList<Image>();
	private static List<Image> lsc = new ArrayList<Image>();
	private static List<AudioClip> sound = new ArrayList<AudioClip>();
	private static List<Font> font = new ArrayList<Font>();

	public ImageRef() {
		ImagePattern wu1 = new ImagePattern(new Image(ClassLoader.getSystemResource("U_1.png").toString()));
		ImagePattern wu2 = new ImagePattern(new Image(ClassLoader.getSystemResource("U_2.png").toString()));
		ImagePattern wu3 = new ImagePattern(new Image(ClassLoader.getSystemResource("U_3.png").toString()));
		ImagePattern wu4 = new ImagePattern(new Image(ClassLoader.getSystemResource("U_4.png").toString()));
		ImagePattern wr1 = new ImagePattern(new Image(ClassLoader.getSystemResource("R_1.png").toString()));
		ImagePattern wr2 = new ImagePattern(new Image(ClassLoader.getSystemResource("R_2.png").toString()));
		ImagePattern wr3 = new ImagePattern(new Image(ClassLoader.getSystemResource("R_3.png").toString()));
		ImagePattern wr4 = new ImagePattern(new Image(ClassLoader.getSystemResource("R_4.png").toString()));
		ImagePattern wd1 = new ImagePattern(new Image(ClassLoader.getSystemResource("D_1.png").toString()));
		ImagePattern wd2 = new ImagePattern(new Image(ClassLoader.getSystemResource("D_2.png").toString()));
		ImagePattern wd3 = new ImagePattern(new Image(ClassLoader.getSystemResource("D_3.png").toString()));
		ImagePattern wd4 = new ImagePattern(new Image(ClassLoader.getSystemResource("D_4.png").toString()));
		ImagePattern wl1 = new ImagePattern(new Image(ClassLoader.getSystemResource("L_1.png").toString()));
		ImagePattern wl2 = new ImagePattern(new Image(ClassLoader.getSystemResource("L_2.png").toString()));
		ImagePattern wl3 = new ImagePattern(new Image(ClassLoader.getSystemResource("L_3.png").toString()));
		ImagePattern wl4 = new ImagePattern(new Image(ClassLoader.getSystemResource("L_4.png").toString()));
		WhiteBomber.add(wu1);
		WhiteBomber.add(wu2);
		WhiteBomber.add(wu3);
		WhiteBomber.add(wu4);
		WhiteBomber.add(wr1);
		WhiteBomber.add(wr2);
		WhiteBomber.add(wr3);
		WhiteBomber.add(wr4);
		WhiteBomber.add(wd1);
		WhiteBomber.add(wd2);
		WhiteBomber.add(wd3);
		WhiteBomber.add(wd4);
		WhiteBomber.add(wl1);
		WhiteBomber.add(wl2);
		WhiteBomber.add(wl3);
		WhiteBomber.add(wl4);
		// --------------------------------------------RedBomber---------------------------------------------
		ImagePattern ru1 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedU_1.png").toString()));
		ImagePattern ru2 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedU_2.png").toString()));
		ImagePattern ru3 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedU_3.png").toString()));
		ImagePattern ru4 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedU_4.png").toString()));
		ImagePattern rr1 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedR_1.png").toString()));
		ImagePattern rr2 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedR_2.png").toString()));
		ImagePattern rr3 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedR_3.png").toString()));
		ImagePattern rr4 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedR_4.png").toString()));
		ImagePattern rd1 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedD_1.png").toString()));
		ImagePattern rd2 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedD_2.png").toString()));
		ImagePattern rd3 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedD_3.png").toString()));
		ImagePattern rd4 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedD_4.png").toString()));
		ImagePattern rl1 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedL_1.png").toString()));
		ImagePattern rl2 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedL_2.png").toString()));
		ImagePattern rl3 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedL_3.png").toString()));
		ImagePattern rl4 = new ImagePattern(new Image(ClassLoader.getSystemResource("RedL_4.png").toString()));
		RedBomber.add(ru1);
		RedBomber.add(ru2);
		RedBomber.add(ru3);
		RedBomber.add(ru4);
		RedBomber.add(rr1);
		RedBomber.add(rr2);
		RedBomber.add(rr3);
		RedBomber.add(rr4);
		RedBomber.add(rd1);
		RedBomber.add(rd2);
		RedBomber.add(rd3);
		RedBomber.add(rd4);
		RedBomber.add(rl1);
		RedBomber.add(rl2);
		RedBomber.add(rl3);
		RedBomber.add(rl4);

		// ------------------------------------------Bomb-----------------------------------------------------------------------
		ImagePattern b1 = new ImagePattern(new Image(ClassLoader.getSystemResource("bomb1_1.png").toString()));
		ImagePattern b2 = new ImagePattern(new Image(ClassLoader.getSystemResource("bomb1_2.png").toString()));
		ImagePattern b3 = new ImagePattern(new Image(ClassLoader.getSystemResource("bomb1_3.png").toString()));
		ImagePattern effu = new ImagePattern(new Image(ClassLoader.getSystemResource("U_Headeffbomb.png").toString()));
		ImagePattern effr = new ImagePattern(new Image(ClassLoader.getSystemResource("R_Headeffbomb.png").toString()));
		ImagePattern effd = new ImagePattern(new Image(ClassLoader.getSystemResource("D_Headeffbomb.png").toString()));
		ImagePattern effl = new ImagePattern(new Image(ClassLoader.getSystemResource("L_Headeffbomb.png").toString()));
		ImagePattern effh = new ImagePattern(new Image(ClassLoader.getSystemResource("H_bodyeffbomb.png").toString()));
		ImagePattern effv = new ImagePattern(new Image(ClassLoader.getSystemResource("V_bodyeffbomb.png").toString()));
		ImagePattern effm = new ImagePattern(new Image(ClassLoader.getSystemResource("mideffbomb.png").toString()));
		bomb1.add(b1);// index0
		bomb1.add(b2);// index1
		bomb1.add(b3);// index2
		bomb1.add(effu);// index3
		bomb1.add(effr);// index4
		bomb1.add(effd);// index5
		bomb1.add(effl);// index6
		bomb1.add(effh);// index7
		bomb1.add(effv);// index8
		bomb1.add(effm);// index9

		// --------------------------------------------Item-----------------------------------------------------------------
		ImagePattern item1 = new ImagePattern(new Image(ClassLoader.getSystemResource("boost.png").toString()));
		ImagePattern item2 = new ImagePattern(new Image(ClassLoader.getSystemResource("Deboost.png").toString()));
		ImagePattern item3 = new ImagePattern(new Image(ClassLoader.getSystemResource("upgradebomb.png").toString()));
		ImagePattern item4 = new ImagePattern(new Image(ClassLoader.getSystemResource("Degradebomb.png").toString()));
		ImagePattern item5 = new ImagePattern(new Image(ClassLoader.getSystemResource("stackbomb.png").toString()));
		ImagePattern item6 = new ImagePattern(new Image(ClassLoader.getSystemResource("Debomb.png").toString()));
		item.add(item1);
		item.add(item2);
		item.add(item3);
		item.add(item4);
		item.add(item5);
		item.add(item6);
		// -----------------------------------------Itemboard--------------------------------------------------------------
		Image ib1 = new Image(ClassLoader.getSystemResource("p1item.png").toString());
		Image ib2 = new Image(ClassLoader.getSystemResource("p2item.png").toString());
		Image ib3 = new Image(ClassLoader.getSystemResource("listitem.png").toString());
		Image ib4 = new Image(ClassLoader.getSystemResource("board.png").toString());
		itemboard.add(ib1);
		itemboard.add(ib2);
		itemboard.add(ib3);
		itemboard.add(ib4);
		// ----------------------------------Start-----------------------------------------------------------------------------
		Image st1 = new Image(ClassLoader.getSystemResource("start1.png").toString());
		Image st2 = new Image(ClassLoader.getSystemResource("start2.png").toString());
		start.add(st1);
		start.add(st2);
		// ---------------------------------loadingscreen-------------------------------------------------------------------------
		Image sc1 = new Image(ClassLoader.getSystemResource("loadscreen.png").toString());
		Image sc2 = new Image(ClassLoader.getSystemResource("loading.png").toString());
		lsc.add(sc1);
		lsc.add(sc2);
		// -----------------------------------Allsound-------------------------------------------------------------------------------
		AudioClip bombsound = new AudioClip(ClassLoader.getSystemResource("bombsound.wav").toString());
		AudioClip bgsound = new AudioClip(ClassLoader.getSystemResource("bgsound.mp3").toString());
		sound.add(bombsound);
		sound.add(bgsound);
		// -----------------------------------Font---------------------------------------------------------------------------------
		Font font1 = Font.loadFont((ClassLoader.getSystemResource("fontprogmeth.TTF").toString()), 50);
		Font font2 = Font.loadFont((ClassLoader.getSystemResource("fontprogmeth.TTF").toString()), 80);
		font.add(font1);
		font.add(font2);
	}

	public static List<ImagePattern> getWhiteBomberImage() {
		return WhiteBomber;
	}

	public static List<ImagePattern> getRedBomberImage() {
		return RedBomber;
	}

	public static List<ImagePattern> getBomb1Image() {
		return bomb1;
	}

	public static List<ImagePattern> getItemImage() {
		return item;
	}

	public static List<Image> getItemboardImage() {
		return itemboard;
	}

	public static List<Image> getStartImage() {
		return start;
	}

	public static List<Image> getLoadScreenImage() {
		return lsc;
	}

	public static List<AudioClip> getSound() {
		return sound;
	}
	public static List<Font> getFont() {
		return font;
	}
}
