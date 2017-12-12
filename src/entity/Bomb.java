package entity;

import object.Gameobject;
import sharedObject.Hitbox;
import sharedObject.ImageRef;
import java.util.ArrayList;
import java.util.List;

import Map.Stage1;
import envi.Brick;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Bomb implements Gameobject{
	private boolean exploded;
	private int bombrange;
	private Hitbox bomb;
	private List<Hitbox> lrec;
	private Thread thread;

	private double x;
	private double y;
	private boolean up = true;
	private boolean down = true;
	private boolean left = true;
	private boolean right = true;
	
	public Bomb(double x,double y,int bombrange) {
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
	public void startBomb(Group root , Player1 p1,Player2 p2) {
		root.getChildren().add(bomb);		
		thread = new Thread(() -> {
			this.bomb.setVisible(true);
			try {
				Thread.sleep(700);
				bomb.setFill(new ImagePattern(ImageRef.getBomb1().get(1)));
				Thread.sleep(700);
				bomb.setFill(new ImagePattern(ImageRef.getBomb1().get(2)));
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.bomb.setVisible(false);
			this.bomb=null;
			
			this.exploded = true;
			
			//draw effected bomb
			int indexj =(int)(this.x-30)/60 ;
			int indexi = (int)(this.y-30)/60 ;
			lrec = new ArrayList<Hitbox>();
			Hitbox c = new Hitbox(x,y,60.0,60.0);
			c.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("mideffbomb.png").toString())));
			lrec.add(c);
			int[][] field = Stage1.field;
			for (int i=1; i <= bombrange;i++) {
			
				if(up==true && indexi-i>=0 && field[indexi-(i)][indexj]!=1) {
					Hitbox u;
					if(i==bombrange) {
						u = new Hitbox(x+6,y-(i*60)+5,48.0,55.0);
						u.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("U_Headeffbomb.png").toString())));
					}else {
						u = new Hitbox(x+6,y-(i*60),48.0,60.0);
						u.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("V_Bodyeffbomb.png").toString())));
					}
					lrec.add(u);
					if (field[indexi-i][indexj]==2) {
						field[indexi-i][indexj]=0;
						Stage1.drawFloor(indexi-i,indexj);
						up = false;
					}
				}else {
					up = false;
				}
				if(down==true && indexi+i<=14 && field[indexi+(i)][indexj]!=1) {
					Hitbox d;
					if(i==bombrange) {
						d = new Hitbox(x+6,y+(i*60),48.0,55.0);
						d.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("D_Headeffbomb.png").toString())));
					}else {
						d = new Hitbox(x+6,y+(i*60),48.0,60.0);
						d.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("V_Bodyeffbomb.png").toString())));
					}
					lrec.add(d);
					if (field[indexi+i][indexj]==2) {
						field[indexi+i][indexj]=0;
						Stage1.drawFloor(indexi+i, indexj);
						down = false;
					}
				}else {
					down = false;
				}
				if(left==true && indexj-i>=0 && field[indexi][indexj-i]!=1) {
					Hitbox l;
					if(i==bombrange) {
						l = new Hitbox(x-(i*60)+5,y+6,55.0,48.0);
						l.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("L_Headeffbomb.png").toString())));
					}else {
						l = new Hitbox(x-(i*60),y+6,60.0,48.0);
						l.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("H_Bodyeffbomb.png").toString())));
					}
					lrec.add(l);
					if (field[indexi][indexj-i]==2) {
						field[indexi][indexj-i]=0;
						Stage1.drawFloor(indexi, indexj-i);
						left = false;
					}
				}else {
					left = false;
				}
				if(right==true && indexj+i<17 && field[indexi][indexj+i]!=1) {
					Hitbox r;
					if(i==bombrange) {
						r = new Hitbox(x+(i*60),y+6,55.0,48.0);						
						r.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("R_Headeffbomb.png").toString())));
					}else {
						r = new Hitbox(x+(i*60),y+6,60.0,48.0);
						r.setFill(new ImagePattern(new Image(ClassLoader.getSystemResource("H_Bodyeffbomb.png").toString())));
					}
					lrec.add(r);
					if (field[indexi][indexj+i]==2) {
						field[indexi][indexj+i]=0;
						Stage1.drawFloor(indexi, indexj+i);
						right = false;
					}
				}else {
					right = false;
				}							
			}
			
			//kill player
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(Hitbox rec: lrec) {
						rec.setVisible(true);
						root.getChildren().add(rec);
						if (rec.CollosionWith(p1.getHerobox())) {
							Player1.setDead();
						}
						if (rec.CollosionWith(p2.getHerobox())) {
							Player2.setDead();
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
			
			//destroy brick & kill player
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					List<Brick> lbrick = Stage1.lbrick;
					for(Hitbox rec: lrec) {
						for (int i=lbrick.size()-1;i>=0;i--) {
							if (rec.CollosionWith(lbrick.get(i).getHitbox())) {
								p1.getlhitbox().remove(lbrick.get(i).getHitbox());
								p2.getlhitbox().remove(lbrick.get(i).getHitbox());
								lbrick.get(i).destroyed(root);
								lbrick.remove(i);
							}
						}
						if (rec.CollosionWith(p1.getHerobox())) {
							Player1.setDead();
						}
						if (rec.CollosionWith(p2.getHerobox())) {
							Player2.setDead();
						}
						rec.setVisible(false);
					}					
				}		
			});
			thread.interrupt();
			
		});thread.start();
	}
	public void pushByHero(Hero hero) {
		while(true) {
			bomb.setLayoutX(bomb.getLayoutX()+1);
			bomb.setLayoutX(bomb.getLayoutX()+1);
		}
	}
	public Hitbox getHitbox() {
		return this.bomb;
	}

}
