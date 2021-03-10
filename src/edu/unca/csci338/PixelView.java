package edu.unca.csci338;

import java.awt.*;

/**
 * Main
 */
public class PixelView extends Frame {

    private int width = 500;
    private int height = 500;

    public Canvas canvas;

    public PixelView(PixelModel model, PixelController controller) {

        // setup
        setSize(width,height);
        setTitle("Pixel Project");

        Panel panel = new Panel();
        panel.setBounds(0, 0, 100, height);
        panel.setBackground(Color.GRAY);
        canvas = new Canvas(width-100, height, 100, 0 , model, controller);
        add(panel);
        add(canvas);

        setVisible(true);

        addWindowListener(controller);
    }
}