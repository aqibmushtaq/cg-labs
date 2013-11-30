package labs;

import static java.lang.Math.*;

public class Vector3D {
	public double x, y, z;

	public Vector3D(double X, double Y, double Z) {
		x = X;
		y = Y;
		z = Z;
	}

	public String toString() {/* Make it look nice to save your debugging time! */
		return String.format("x=%s y=%s z=%s", x, y, z);
	}

	public Vector3D clone() throws CloneNotSupportedException {
		return new Vector3D(x, y, z);
	}

	public double L2norm() {
		return sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
	}

	public double dotProduct(Vector3D v) {
		return (x * v.x) + (y * v.y) + (z * v.z);
	}

	//http://www.mathsisfun.com/algebra/vectors-cross-product.html
	public Vector3D crossProduct(Vector3D v) {
		return new Vector3D(
				y * v.z - z * v.y, 
				z * v.x - x * v.z,
				x * v.y - y * v.x
				);
	}

	public void normalize() {
		double magnitude = L2norm();
		x = x / magnitude;
		y = y / magnitude;
		z = z / magnitude;
	}
	
	public Vector3D transform(Matrix m) {
		Point3D p1 = new Point3D(this.x, this.y, this.z);
		Point3D p2 = p1.transform(m);
		return new Vector3D(p2.x, p2.y, p2.z);
	}
}
