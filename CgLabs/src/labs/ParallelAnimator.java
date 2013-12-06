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
    private static final String[] files = {"./cube.dat", "./pyramid.dat", /*"./box.dat"*/};
    protected Camera camera;
    private Scene scene;

    private double xRotation = 17;
    private double yRotation = 50;
    private double zRotation = 20;

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
        mX.setRotationX(1 / xRotation);
        mY.setRotationY(1 / yRotation);
        mZ.setRotationZ(1 / zRotation);
        scene.transform(mZ.multiply(mY.multiply(mX)));

        scene.draw(camera, g);
    }

    public void increaseXRotation() {
        xRotation += 1;
    }

    public void decreaseXRotation() {
        if (xRotation == 1)
            return;
        xRotation -= 1;
    }

    public void increaseYRotation() {
        yRotation += 1;
    }

    public void decreaseYRotation() {
        if (yRotation == 1)
            return;
        yRotation -= 1;
    }

    public void increaseZRotation() {
        zRotation += 1;
    }

    public void decreaseZRotation() {
        if (zRotation == 1)
            return;
        zRotation -= 1;
    }

    public void setCamera (Camera c) {
        camera = c;
    }
}