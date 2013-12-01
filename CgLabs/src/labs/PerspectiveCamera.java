package labs;

import static java.lang.Math.*;

/**
 * Created with IntelliJ IDEA.
 * User: Aqib
 * Date: 01/12/13
 * Time: 03:21
 * To change this template use File | Settings | File Templates.
 */
public class PerspectiveCamera extends Camera {
    private Point3D cop = new Point3D(0, 0, -4); //centre of projection

    public PerspectiveCamera(double xmin, double xmax, double ymin, double ymax) {
        super(xmin, xmax, ymin, ymax);
    }

    public Vector3D getVPN() {
        Vector3D d = super.getVPN();
        return new Vector3D(d.x, d.y, d.z);
    }

    protected Point3D projectionTransform(final Point3D p) {
        double distance = cop.distance(new Point3D(0, 0, 0));

        double xPrime = (p.x * distance) / abs((p.z - cop.z));
        double yPrime = (p.y * distance) / abs((p.z - cop.z));
        double zPrime = 0;

        return new Point3D(xPrime, yPrime, zPrime);
    }

    public void setupCOP(Point3D cop) {
        this.cop = cop;
    }
}
