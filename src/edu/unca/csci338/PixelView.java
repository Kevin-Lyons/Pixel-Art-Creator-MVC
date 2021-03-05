package edu.unca.csci338;

import java.awt.*;

/**
 * Main
 */
public class PixelView extends Frame {

    private int width = 500;
    private int height = 500;
    private int pixSize;
    private int offsetX;
    private int offsetY;

    private PixelModel model;

    public PixelView(PixelModel model, PixelController controller) {

        // fields
        this.model = model;
        this.pixSize = Math.min(width / model.getWidth(), height / model.getHeight());
        this.offsetX = 0;
        this.offsetY = 0;

        // setup
        setSize(width,height);
        setTitle("Pixel Project");
        addPixWidth(-5);
        setVisible(true);

        addMouseListener(controller);
        addMouseMotionListener(controller);
        addWindowListener(controller);
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
                g.fillRect(col*pixSize + offsetX, row*pixSize + offsetY, pixSize, pixSize);
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

        return new Point((x - offsetX)/pixSize,(y - offsetY)/pixSize);
    }
}