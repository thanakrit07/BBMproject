package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.Bomb;
import entity.Player1;
import entity.Player2;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> listoj;
	private Comparator<IRenderable> comparator;

	static {
		loadResource();
	}

	public RenderableHolder() {
		listoj = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static void loadResource() {

	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		listoj.add(entity);
		Collections.sort(listoj, comparator);
		for (IRenderable x : listoj) {
			if (x instanceof Player1)
				System.out.println("P1");
			if (x instanceof Player2)
				System.out.println("P2");
			if (x instanceof Bomb)
				System.out.println("bomb");

		}
	}

	public void update() {
		for (int i = listoj.size() - 1; i >= 0; i--) {
			if (!listoj.get(i).isVisible())
				listoj.remove(i);
		}
	}

	public List<IRenderable> getListhitbox() {
		return listoj;
	}
}