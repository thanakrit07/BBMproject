//package sharedObject;
//
//import object.Gameobject;
//import Map.Stage1;
//import entity.Player1;
//import entity.Player2;
//import envi.Wall;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
//
//public class GameLogic{
//	private Player1 p1;
//	private Player2 p2;
//	public GameLogic(){
//		Stage1 stage1 = new Stage1();
//		RenderableHolder.getInstance().add(stage1);
//		p1 = new Player1(20, 20);
//		p2 = new Player2(1010, 850);
//		Wall wall = new Wall(500,500,60,60);
//		p1.getlhitbox().add(wall.getHitbox());
//		p2.getlhitbox().add(wall.getHitbox());
//		addNewObject(wall);
//		addNewObject(p1.getHerobox());
//		addNewObject(p2.getHerobox());
//	}
//
//	
//	protected void addNewObject(IRenderable object) {
//		RenderableHolder.getInstance().add(object);
//	}
//	public void logicUpdate() {
//		p1.update();
//		p2.update();
//	}
//
//
//
//
//}
