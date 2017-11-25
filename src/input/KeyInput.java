package input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javafx.scene.input.KeyCode;

public class KeyInput {

	public static ArrayList<KeyCode> keyPressed = new ArrayList<>();
	public static Set<KeyCode> setkeyPressed = new HashSet<KeyCode>();

	public static void setKeyPressed(KeyCode key, boolean pressed) {
		if (pressed) {
			if (!keyPressed.contains(key)) {
				keyPressed.add(key);
			}
		} else {
			keyPressed.remove(key);
			setkeyPressed.remove(key);
		}
	}

	public static boolean getKeyPressed(KeyCode key) {
		return keyPressed.contains(key);
	}
}
