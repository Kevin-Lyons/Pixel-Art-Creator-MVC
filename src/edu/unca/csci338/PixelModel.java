package edu.unca.csci338;

import java.awt.Color;
import java.awt.Point;

/**
 * PixelModel
 */
public class PixelModel {

    private int width;
    private int height;
    private Color currentColor;

    private Color[] palette = {Color.decode("#332c50"), Color.decode("#46878f"), Color.decode("#94e344"), Color.decode("#e2f3e4")};

    private Color[][] canvas;

    public PixelModel(int width, int height) {

        this.width = width;
        this.height = height;
        this.currentColor = palette[0];
        this.canvas = new Color[height][width];
    }

    public void setPixel(Point p, Color c) {

        canvas[(int) p.getY()][(int) p.getX()] = c;
    }

    public Color[][] getCanvas() {

        return canvas;
    }

    public Color[] getPalette() {

        return palette;
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {

        return height;
    }

    public void setPaletteColor(int index) {

        currentColor = palette[index];
    }

    public Color getColor() {

        return currentColor;
    }
}