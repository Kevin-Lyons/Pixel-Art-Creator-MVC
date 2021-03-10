package edu.unca.csci338;

import java.awt.*;

public class ColorPicker extends Panel {
    
    private int width;
    private int height;
    private int offsetX;
    private int offsetY;
    private int rectSize;
    private int ratio;

    private PixelModel model;

    public ColorPicker(int width, int height, PixelModel model, PixelController controller) {

        // fields
        this.width = width;
        this.height = height;
        this.offsetX = 0;
        this.offsetY = 0;
        this.model = model;

        this.rectSize = 25;

        setSize(width, height);
        setBackground(Color.GRAY);

        addMouseListener(controller);
    }

    public void paint(Graphics g) {
        
        Color[] palette = model.getPalette();

        ratio = getNearestRatio(palette.length, height/width);
        offsetX = (width - (palette.length/ratio)*rectSize)/2;
        offsetY = (height - ratio*rectSize)/2;

        for (int i=0; i < palette.length; i++) {

            int x = i/ratio*rectSize + offsetX;
            int y = i%ratio*rectSize + offsetY;

            g.setColor(palette[i]);
            g.fillRect(x, y, rectSize, rectSize);

        }
    }

    public int getPointColor(int x, int y) {

        int newX = (x - offsetX)/rectSize;
        int newY = (y - offsetY)/rectSize;

        return newX*ratio + newY;
    }

    private int getNearestRatio(int n, int r) {

        int closest = 1;
        for (int i=2; i < Math.sqrt(n); i++) {

            // finding factors of n
            if (n % i == 0) {
                if (Math.abs(r - n/i/i) < Math.abs(r - n/closest/closest)) {
                    closest = i;
                } else
                    break;
            }
        }
        return n/closest;
    }
}
