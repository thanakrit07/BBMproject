package object;

import sharedObject.IRenderable;

public abstract class Gameobject implements IRenderable{
	protected double x,y,w,h;
	protected int z;
	protected boolean visble;
	public Gameobject(double x, double y, double w, double h) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;			
	}	
}
