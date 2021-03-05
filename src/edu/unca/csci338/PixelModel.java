package edu.unca.csci338;

import java.awt.Color;
import java.awt.Point;

/**
 * PixelModel
 */
public class PixelModel {

    private int width;
    private int height;

    private Color[][] canvas;

    public PixelModel(int width, int height) {

        this.width = width;
        this.height = height;
        this.canvas = new Color[height][width];
    }

    public void setPixel(Point p, Color c) {

        canvas[(int) p.getY()][(int) p.getX()] = c;
    }

    public Color[][] getCanvas() {

        return canvas;
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {

        return height;
    }
}