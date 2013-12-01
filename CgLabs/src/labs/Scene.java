package labs;

import java.awt.*;

public class Scene {
	private GObject[] objs;

	public Scene(String[] fileNames) {
        objs = new GObject[fileNames.length];
        for (int i = 0; i < fileNames.length; i++)
            objs[i] = new GObject(fileNames[i]);
	}

	public void transform(Matrix m) {
        for (GObject o : objs)
            o.transform(m);
	}

	public void draw(Camera c, Graphics g) {
        //get the view point vector
        Vector3D vpn = c.getVPN();

        //go through all the objects in this scene
        for (int i = 0; i < objs.length; i++) {
            GObject currObj = objs[i];

            //convert all the points to this object to map to this view port
            Point3D[] points = new Point3D[currObj.vertex.length];
            for (int j = 0; j < currObj.vertex.length; j++)
                points[j] = c.project(currObj.vertex[j]);

            //draw each face of this object
            for (int j = 0; j < currObj.face.length; j++) {
                Face currFace = currObj.face[j];

                int indexLength = currFace.index.length;
                int[] xVals = new int[indexLength];
                int[] yVals = new int[indexLength];
                //check if the face is front facing
                if (Point3D.isFrontFace(points[currFace.index[0]], points[currFace.index[1]], points[currFace.index[2]], vpn)) {
                    //store all the points which make up the face
                    for (int k = 0; k < indexLength; k++) {
                        xVals[k] = (int) points[currFace.index[k]].x;
                        yVals[k] = (int) points[currFace.index[k]].y;
                    }
                }

                g.setColor(currFace.color);
                g.fillPolygon(xVals, yVals, indexLength);
            }


        }
    }

	public String toString() {
		String str = "";
		for (GObject o : objs)
			str += "\n" + o.toString();
		return str;
	}
}
