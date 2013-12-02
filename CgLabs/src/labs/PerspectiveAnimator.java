package labs;

/**
 * Created with IntelliJ IDEA.
 * User: Aqib
 * Date: 01/12/13
 * Time: 03:23
 * To change this template use File | Settings | File Templates.
 */
public class PerspectiveAnimator extends ParallelAnimator {
    protected void setupCamera() {
        camera = new PerspectiveCamera(-5, 5, -5, 5);
        ((PerspectiveCamera) camera).setupCOP(new Point3D(0, 0, 100));
    }

    public static void main(String[] args) {
        new PerspectiveAnimator().loop();
    }
}