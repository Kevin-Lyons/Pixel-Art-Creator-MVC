package edu.unca.csci338;

import java.awt.*;

/**
 * Main
 */
public class PixelView extends Frame {

    private int width = 500;
    private int height = 500;

    public Canvas canvas;
    public ColorPicker picker;

    public PixelView(PixelModel model, PixelController controller) {

        // setup
        setSize(width,height);
        setTitle("Pixel Project");

        picker = new ColorPicker(100, height, model, controller);
        canvas = new Canvas(width-100, height, 100, 0 , model, controller);
        add(picker);
        add(canvas);

        setVisible(true);

        addWindowListener(controller);
    }
}