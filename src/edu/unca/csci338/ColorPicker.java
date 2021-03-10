package edu.unca.csci338;

import java.awt.*;

public class ColorPicker extends Panel {
    
    private int width;
    private int height;
    private int paddingX;
    private int paddingY;
    private int rectSize = 50;

    private PixelModel model;

    public ColorPicker(int width, int height, PixelModel model, PixelController controller) {

        // fields
        this.width = width;
        this.height = height;
        this.paddingX = (width - rectSize)/2;
        this.model = model;

        setSize(width, height);
        setBackground(Color.GRAY);

        addMouseListener(controller);
    }

    public void paint(Graphics g) {
        
        Color[] palette = model.getPalette();
        paddingY = (height - palette.length*rectSize)/2;

        for (int i=0; i < palette.length; i++) {

            g.setColor(palette[i]);
            g.fillRect(paddingX, i*50 + paddingY, 50, 50);
        }
    }

    public int getPointColor(int x, int y) {

        return (y - paddingY)/rectSize;
    }
}
