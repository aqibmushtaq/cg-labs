package labs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        ((PerspectiveCamera) camera).setupCOP(new Point3D(0, 0, 3));
    }

    public static void main(String[] args) {

        PerspectiveAnimator pa = new PerspectiveAnimator();

        showHelp(pa);

        pa.addKeyListener(new PerspectiveKeyListener(pa));

        pa.loop();
    }

    public static void showHelp (Component parent) {
        JOptionPane.showMessageDialog(parent,
                "Help: F1\n\n" +
                        "Speed up X: A\n" +
                        "Slow down X: Z\n\n" +

                        "Speed up Y: S\n" +
                        "Slow down Y: X\n\n" +

                        "Speed up Z: D\n" +
                        "Slow down Z: C\n\n" +

                        "Un-Perspective Mode: F\n" +
                        "Perspective Mode: V"
        );
    }
}
class PerspectiveKeyListener implements KeyListener {

    private JFrame target;

    public PerspectiveKeyListener (JFrame target) {
        this.target = target;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ParallelAnimator animator = (ParallelAnimator)target;

        int keyCode = e.getKeyCode();

        //change x-axis speed
        if (keyCode == KeyEvent.VK_A)
            animator.decreaseXRotation();
        else if (keyCode == KeyEvent.VK_Z)
            animator.increaseXRotation();

        //change y-axis speed
        else if (keyCode == KeyEvent.VK_S)
            animator.decreaseYRotation();
        else if (keyCode == KeyEvent.VK_X)
            animator.increaseYRotation();

        //change z-axis speed
        else if (keyCode == KeyEvent.VK_D)
            animator.decreaseZRotation();
        else if (keyCode == KeyEvent.VK_C)
            animator.increaseZRotation();

        //change to un-perspective camera
        else if (keyCode == KeyEvent.VK_F)
            animator.setCamera(new Camera(-5, 5,-5 ,5));

        //change to perspective camera
        else if (keyCode == KeyEvent.VK_V) {
            PerspectiveCamera c = new PerspectiveCamera(-5, 5, -5, 5);
            c.setupCOP(new Point3D(0, 0, 3));
            animator.setCamera(c);
        }

        //show help
        else if (keyCode == KeyEvent.VK_F1)
            PerspectiveAnimator.showHelp(target);

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}