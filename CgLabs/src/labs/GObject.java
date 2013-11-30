package labs;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GObject {
	public Point3D[] vertex;
	public Face[] face;

	public GObject(Point3D[] v, Face[] f) {
		vertex = v;
		face = f;
	}

	public GObject(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new FileReader(fileName));
			
			String input;
			String[] comp;
			
			//input vertices
			vertex = new Point3D[Integer.parseInt(br.readLine().trim())];
			for (int i = 0; i < vertex.length; i++) {
				input = br.readLine();
				comp = input.split("\\s");
				vertex[i] = new Point3D(
						Double.parseDouble(comp[0]),
						Double.parseDouble(comp[1]),
						Double.parseDouble(comp[2])
						);
			}
			
			br.readLine();
			
			//input faces
			face = new Face[Integer.parseInt(br.readLine().trim())];
			for (int i = 0; i < face.length && br.ready(); i++) {
				//vertices
				br.readLine(); //waste the first line
				input = br.readLine();
				comp = input.split("\\s");
				int[] vertix = new int[comp.length];
				for (int j = 0; j < comp.length; j++) {
					vertix[j] = Integer.parseInt(comp[j]);
				}
				
				//colour
				input = br.readLine();
				comp = input.split("\\s");
				Color color = new Color(
						Float.parseFloat(comp[0]),
						Float.parseFloat(comp[1]),
						Float.parseFloat(comp[2])
						);
				
				//add this face
				face[i] = new Face(vertix, color);
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			return;
		} finally {
			if (br == null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	public void transform(Matrix m) {
		for(int i=0; i<vertex.length; i++) {
			vertex[i] = new Point3D(
					vertex[i].x*m.m[0][0]+vertex[i].y*m.m[0][1]+vertex[i].z*m.m[0][2]+m.m[0][3], 
				    vertex[i].x*m.m[1][0]+vertex[i].y*m.m[1][1]+vertex[i].z*m.m[1][2]+m.m[1][3], 
				    vertex[i].x*m.m[2][0]+vertex[i].y*m.m[2][1]+vertex[i].z*m.m[2][2]+m.m[2][3]
			);
		}
				
	}

	public String toString() {
		return String.format("vertex=%s, face=%s", vertex, face);
	}
}
