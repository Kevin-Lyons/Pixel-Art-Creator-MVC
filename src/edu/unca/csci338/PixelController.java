import java.awt.*;
import java.awt.event.*;

/**
 * PixelController
 */
public class PixelController implements MouseListener, WindowListener {

    private PixelModel model = new PixelModel(20,20);
    private PixelView view = new PixelView(model, this);

    /**
     * Mouse Handling
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        draw(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void draw(MouseEvent e) {
        
        // determine color
        Color c;
        if (e.getButton() == MouseEvent.BUTTON1) {
            c = Color.BLACK;
        } else
            c = null;

        // actual drawing
        model.setPixel(e.getX()/view.getPixWidth(), e.getY()/view.getPixWidth(), c);
        view.repaint();
    }

    /**
     * Window handling
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        
        view.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        
        new PixelController();
    }
}