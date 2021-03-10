package edu.unca.csci338;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PixelModel
 */
public class PixelModel {

    private int width;
    private int height;
    private Color currentColor;

    private ArrayList<Color> palette;

    private Color[][] canvas;

    public PixelModel(int width, int height) {

        this.width = width;
        this.height = height;
        loadPalette(new File("src/palettes/kirokaze-gameboy.hex"));
        this.currentColor = palette.get(0);
        this.canvas = new Color[height][width];
    }
    
    private void loadPalette(File f) {

        Scanner scan;
        try {
            scan = new Scanner(f);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        palette = new ArrayList<Color>();
        while(scan.hasNextLine()) {

            String hex = "#" + scan.nextLine();
            palette.add(Color.decode(hex));
        }
        scan.close();
    }

    public void setPixel(Point p, Color c) {

        canvas[(int) p.getY()][(int) p.getX()] = c;
    }

    public Color[][] getCanvas() {

        return canvas;
    }

    public Color[] getPalette() {

        return palette.toArray(new Color[palette.size()]);
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {

        return height;
    }

    public void setPaletteColor(int index) {

        currentColor = palette.get(index);
    }

    public Color getColor() {

        return currentColor;
    }
}