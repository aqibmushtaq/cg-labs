package labs;

import java.awt.*;

public class Scene {
	private GObject[] obj;

	public Scene(String[] fileName) {
	}

	public void transform(Matrix m) {
	}

	// wait until next lab for Camera
	// public void draw(Camera c, Graphics g){}

	public String toString() {
		String str = "";
		for (GObject o : obj) 
			str += "\n" + o.toString();
		return str;
	}
}
