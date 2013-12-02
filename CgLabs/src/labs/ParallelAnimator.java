package labs;

import java.awt.*;
import javax.swing.*;

import static java.lang.Math.*;

/**
 * Created with IntelliJ IDEA.
 * User: Aqib
 * Date: 30/11/13
 * Time: 18:19
 * To change this template use File | Settings | File Templates.
 */
public class ParallelAnimator extends Animator {
    private static final String[] files = {"./cube.dat", "./pyramid.dat", "./box.dat"};
    protected Camera camera;
    private Scene scene;

    public ParallelAnimator() {
        super();

        scene = new Scene(files);
        setupCamera();
    }

    protected void setupCamera() {
        camera = new Camera(-5, 5, -5, 5);
    }

    protected void animate(Graphics g) {
        camera.setViewport(getWidth(), getHeight());

        if (g == null || scene == null || camera == null)
            return;

        Matrix mX = new Matrix(), mY = new Matrix(), mZ = new Matrix();
        mX.setRotationX(-PI / 1);
        mY.setRotationY(PI / 5);
        mZ.setRotationZ(PI / 1);
        scene.transform(mZ.multiply(mY.multiply(mX)));

        scene.draw(camera, g);
    }

    public static void main(String[] args) {
        new ParallelAnimator().loop();
    }
}