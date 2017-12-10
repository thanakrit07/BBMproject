package entity;

import object.Gameobject;
import sharedObject.Hitbox;
import sharedObject.ImageRef;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class Bomb extends Gameobject{
	private boolean exploded;
	private int bombrange;
	private Hitbox bomb;
	List<Hitbox> lrec;

	private double x;
	private double y;
	private boolean up = true;
	private boolean down = true;
	private boolean left = true;
	private boolean right = true;
	
//	private Player1 p1
//	private Hitbox p2 = Player2.getHerobox();
	
	public Bomb(double x,double y,int bombrange) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.exploded = false;
		this.bombrange=bombrange;
		bomb =new Hitbox(x,y,60,60);
		bomb.setFill(new ImagePattern(ImageRef.getBomb1().get(0)));
		
	}
	
	public boolean IsExploded() {
		return this.exploded;
	}
	public void startBomb(Group root ,int[][] field,Player1 p1,Player2 p2) {
		
		Thread thread = new Thread(() -> {
			this.bomb.setVisible(true);
			try {
				Thread.sleep(1000);
				bomb.setFill(new ImagePattern(ImageRef.getBomb1().get(1)));
				Thread.sleep(1000);
				bomb.setFill(new ImagePattern(ImageRef.getBomb1().get(2)));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.bomb.setVisible(false);
			this.bomb=null;
			
			this.exploded = true;
			
			int indexj =(int)(this.x-30)/60 ;
			int indexi = (int)(this.y-30)/60 ;
			lrec = new ArrayList<Hitbox>();
			Hitbox c = new Hitbox(x,y,60.0,60.0);
			c.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("mideffbomb.png").toString())));
			lrec.add(c);
			for (int i=1; i <= bombrange;i++) {
			
				
				//check wall
				if(up==true && indexi-i>=0 && field[indexi-(i)][indexj]!=1) {
					Hitbox u = new Hitbox(x,y-(i*60),60.0,60.0);
					if(i==bombrange) {
						
						u.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("U_Headeffbomb.png").toString())));
					}else {
						u.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("V_Bodyeffbomb.png").toString())));
					}
					lrec.add(u);
				}else {
					up = false;
				}
				if(down==true && indexi+i<=14 && field[indexi+(i)][indexj]!=1) {
					Hitbox d = new Hitbox(x,y+(i*60),60.0,60.0);
					if(i==bombrange) {
						
						d.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("D_Headeffbomb.png").toString())));
					}else {
						d.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("V_Bodyeffbomb.png").toString())));
					}
					lrec.add(d);
				}else {
					down = false;
				}
				if(left==true && indexj-i>=0 && field[indexi][indexj-i]!=1) {
					Hitbox l = new Hitbox(x-(i*60),y,60.0,60.0);
					if(i==bombrange) {
						
						l.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("L_Headeffbomb.png").toString())));
					}else {
						l.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("H_Bodyeffbomb.png").toString())));
					}
					lrec.add(l);
				}else {
					left = false;
				}
				if(right==true && indexj+i<17 && field[indexi][indexj+i]!=1) {
					Hitbox r = new Hitbox(x+(i*60),y,60.0,60.0);
					if(i==bombrange) {
						
						r.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("R_Headeffbomb.png").toString())));
					}else {
						r.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("H_Bodyeffbomb.png").toString())));
					}
					lrec.add(r);
				}else {
					right = false;
				}							
			}
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(Hitbox rec: lrec) {
						rec.setVisible(true);
						root.getChildren().add(rec);
						if (rec.CollosionWith(p1.getHerobox())) {
							p1.setDead();
						}
						if (rec.CollosionWith(p2.getHerobox())) {
							p2.setDead();
						}
					}	
				}				
			});
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(Hitbox rec: lrec) {
						rec.setVisible(false);					
					}					
				}		
			});

		});thread.start();
	}
	public Hitbox getUnitbox() {
		return this.bomb;
	}

}
