package src.edu.unca.csci338;

import java.awt.*;

/**
 * Main
 */
public class PixelView extends Frame {

    private int width = 500;
    private int height = 500;
    private int pixSize;

    private PixelModel model;

    public PixelView(PixelModel model, PixelController controller) {

        // fields
        this.model = model;
        this.pixSize = Math.min(width / model.getWidth(), height / model.getHeight());

        // setup
        setSize(width,height);
        setTitle("Pixel Project");
        setVisible(true);

        addMouseListener(controller);
        addWindowListener(controller);
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
                g.fillRect(col*pixSize, row*pixSize, pixSize, pixSize);
            }
        }
    }

    public int getPixWidth() {

        return pixSize;
    }
}