package edu.unca.csci338;

import java.awt.*;
import java.awt.event.*;

/**
 * PixelController
 */
public class PixelController implements MouseListener, MouseMotionListener, WindowListener, MouseWheelListener {

    private PixelModel model = new PixelModel(16,16);
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

        Class<?> className = e.getSource().getClass();
        if (className == Canvas.class) {
            draw(e);
        } else if (className == ColorPicker.class) {
            setColor(e);
        }
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
            view.canvas.addPixWidth(1);
        } else
            view.canvas.addPixWidth(-1);
        view.canvas.repaint();
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
            c = model.getColor();
        } else
            c = null;

        // actual drawing
        model.setPixel(view.canvas.getPoint(e.getX(), e.getY()), c);
        view.canvas.repaint();
    }

    private void setColor(MouseEvent e) {

        model.setPaletteColor(view.picker.getPointColor(e.getX(), e.getY()));
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