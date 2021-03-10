package edu.unca.csci338;

import java.awt.*;

public class Canvas extends Panel {
    
    private int width;
    private int height;
    private int pixSize;
    private int offsetX;
    private int offsetY;
    private int paddingX;
    private int paddingY;

    private PixelModel model;

    public Canvas(int width, int height, int paddingX, int paddingY, PixelModel model, PixelController controller) {

        // fields
        this.width = width;
        this.height = height;
        this.pixSize = Math.min(width / model.getWidth(), height / model.getHeight());
        this.offsetX = 0;
        this.offsetY = 0;
        this.paddingX = paddingX;
        this.paddingY = paddingY;

        this.model = model;

        // setup
        addPixWidth(-5);

        addMouseListener(controller);
        addMouseMotionListener(controller);
        addMouseWheelListener(controller);
    }

    public void paint(Graphics g) {

        Color[][] canvas = model.getCanvas();
        
        // pixel canvas drawing
        for (int row=0; row < model.getHeight(); row++) {
            for (int col=0; col < model.getWidth(); col++) {

                // choose color
                if (canvas[row][col] != null) {
                    g.setColor(canvas[row][col]);
                } else {
                    // checkerboard pattern
                    if (row % 2 == col % 2) {
                        g.setColor(Color.LIGHT_GRAY);
                    } else
                        g.setColor(Color.WHITE);
                }
                
                // draw
                g.fillRect(col*pixSize + offsetX + paddingX, row*pixSize + offsetY + paddingY, pixSize, pixSize);
            }
        }
    }

    public int getPixWidth() {

        return pixSize;
    }

    public void addPixWidth(int amount) {

        if (pixSize+amount < 1)
            return;

        pixSize += amount;
        offsetX = ( width - pixSize*model.getWidth() ) / 2;
        offsetY = ( height - pixSize*model.getHeight() ) / 2;

    }

    public Point getPoint(int x, int y) {

        return new Point((x - offsetX - paddingX)/pixSize,(y - offsetY - paddingY)/pixSize);
    }
}
