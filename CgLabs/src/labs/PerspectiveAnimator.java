package labs;

import javax.swing.*;
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

        JOptionPane.showMessageDialog(pa,
                "Speed up x: a\n" +
                        "Slow down x: z\n\n" +
                        "Speed up y: s\n" +
                        "Slow down y: x\n\n" +
                        "Speed up z: d\n" +
                        "Slow down z: c\n"
        );

        pa.addKeyListener(new PerspectiveKeyListener(pa));

        pa.loop();
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

        if (keyCode == KeyEvent.VK_A)
            animator.decreaseXRotation();
        else if (keyCode == KeyEvent.VK_Z)
            animator.increaseXRotation();

        else if (keyCode == KeyEvent.VK_S)
            animator.decreaseYRotation();
        else if (keyCode == KeyEvent.VK_X)
            animator.increaseYRotation();

        else if (keyCode == KeyEvent.VK_D)
            animator.decreaseZRotation();
        else if (keyCode == KeyEvent.VK_C)
            animator.increaseZRotation();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}