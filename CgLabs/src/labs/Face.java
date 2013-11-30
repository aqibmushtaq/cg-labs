package labs;

import java.awt.Color;

public class Face {
	public int[] index;
	public Color color;

	public Face(int[] i, Color c) {
		index = i;
		color = c;
	}

	public String toString() {
		return String.format("index=%s, color=%s", index, color);
	}
}