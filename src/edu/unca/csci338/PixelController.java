package edu.unca.csci338;

import java.awt.*;
import java.awt.event.*;

/**
 * PixelController
 */
public class PixelController implements MouseListener, MouseMotionListener, WindowListener, MouseWheelListener {

    private PixelModel model = new PixelModel(20,20);
    private PixelView view = new PixelView(model, this);

    private boolean isLeftClick = true;

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
    
    @Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
  
    	draw(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    public void mouseWheelMoved(MouseWheelEvent e) {
        
        if (e.getWheelRotation() < 0) {
            view.setPixWidth(1);
        } else
            view.setPixWidth(-1);
        view.repaint();
    }

    private void draw(MouseEvent e) {
        
        // update click
        if (e.getButton() == MouseEvent.BUTTON1)
            isLeftClick = true; 
        if (e.getButton() == MouseEvent.BUTTON3)
            isLeftClick = false;

        // get color
        Color c;
        if (isLeftClick) {
            c = Color.BLACK;
        } else
            c = null;

        // actual drawing
        model.setPixel(view.getPoint(e.getX(), e.getY()), c);
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