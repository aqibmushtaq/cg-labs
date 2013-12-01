package labs;

import static java.lang.Math.*;

public class Point3D {

	public double x, y, z;

	public Point3D(double X, double Y, double Z) {
		x = X;
		y = Y;
		z = Z;
	}

	public double distance(Point3D p) {
		return sqrt(pow(p.x - x, 2) + pow(p.y - y, 2) + pow(p.z - z, 2));
	}
	
	public Vector3D vector (Point3D p) {
		return new Vector3D(this.x - p.x, this.y - p.y, this.z - p.z);
	}
	
	public String toString() {
		return String.format("x=%s y=%s z=%s", x, y, z);
	}
	
	public static Vector3D faceNormal(Point3D p1, Point3D p2, Point3D p3) {
		Vector3D v1 = p2.vector(p1);
		Vector3D v2 = p3.vector(p1);
		return v1.crossProduct(v2);
	}
	
	public static boolean isFrontFace(Point3D p1, Point3D p2, Point3D p3, Vector3D vpn) {
		double nDotVpn = faceNormal(p1, p2, p3).dotProduct(vpn);
		return nDotVpn > 0 ? true : false;
	}
	
	public Point3D transform(Matrix m)
	{
		double x = this.x*m.m[0][0]+this.y*m.m[0][1]+this.z*m.m[0][2]+m.m[0][3];
		double y = this.x*m.m[1][0]+this.y*m.m[1][1]+this.z*m.m[1][2]+m.m[1][3];	
		double z = this.x*m.m[2][0]+this.y*m.m[2][1]+this.z*m.m[2][2]+m.m[2][3];
		return new Point3D(x,y,z);
	}
}
