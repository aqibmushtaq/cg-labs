package labs;

/**
 * Created with IntelliJ IDEA.
 * User: Aqib
 * Date: 30/11/13
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */
public class Camera {

    private double xmin, xmax, ymin, ymax;
    private double fcp, bcp;  //NOT USED: front & back clippling planes
    private double ax, bx, ay, by;

    public Camera(double xmin, double xmax, double ymin, double ymax) {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }

    public Vector3D getVPN() {
        Vector3D v1 = new Vector3D(1,0,0);
        Vector3D v2 = new Vector3D(0,1,0);
        return v1.crossProduct(v2);
    }

    private Point3D cameraTransform(final Point3D p) {
        return new Point3D(p.x, p.y, p.z);
    }

    protected Point3D projectionTransform(final Point3D p) {
        return new Point3D(p.x,p.y,0);
    }

    protected Point3D viewportTransform(final Point3D p) {
        double xPrime = ax + bx*p.x;
        double yPrime = ay + by*p.y;
        return new Point3D(xPrime, yPrime, 0);
    }

    public final Point3D project(final Point3D p) {
        Point3D temp = cameraTransform(p);
        temp = projectionTransform(temp);
        return viewportTransform(temp);
    }

    public void setViewport(int width, int height) {
        double vXMin = 0;
        double vXMax = width;

        double vYMin = 0;
        double vYMax = height;

        // view point
        double dVX = vXMax - vXMin;
        double dVY = vYMax - vYMin;

        // window
        double dWX = xmax - xmin;
        double dWY = ymax - ymin;

        bx = dVX / dWX;
        by = dVY / dWY;

        ax = vXMin - bx*xmin;
        ay = vYMin - by*ymin;
    }

}