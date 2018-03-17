/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba2;

/**
 *
 * @author andre
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SuppressWarnings("all")
public class Screen implements Rotatable {

    private int xSize, ySize;
    private List<List<Pixel>> screen;

    public Screen(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        screen = getEmptyScreen(xSize, ySize);
    }


    void putLine(final Point a, final Point b) {
        putLine(a.getX(), a.getY(), b.getX(), b.getY());
    }

    /**
     * I am sorry about that, this code copied and pasted almost "as is"
     * from guidelines (looks like HY TAKOE)
     */
    void putLine(int x0, int y0, int x1, int y1) {
        int dx = 1;
        int a = x1 - x0;
        if (a < 0) {
            dx = -1;
            a = -a;
        }
        int dy = 1;
        int b = y1 - y0;
        if (b < 0) {
            dy = -1;
            b = -b;
        }
        int two_a = 2 * a;
        int two_b = 2 * b;
        int xcrit = -b + two_a;
        int eps = 0;
        while (true) {
            putPoint(x0, y0);
            if (x0 == x1 && y0 == y1) break;
            if (eps <= xcrit) {
                x0 += dx;
                eps += two_b;
            }
            if (eps >= a || a < b) {
                y0 += dy;
                eps -= two_a;
            }
        }
    }

    void putPoint(final Point p) {
        screen.get(p.getX()).set(p.getY(), Pixel.BLACK);
    }

    void putPoint(final int x, final int y) {
        screen.get(x).set(y, Pixel.BLACK);
    }

    void clear() {
        screen = getEmptyScreen(this.xSize, this.ySize);
    }

    public void draw() {
        screen.forEach(listOfPixels -> {
            listOfPixels.forEach(pixel ->
                    System.out.print(pixel.getFiller()));
            System.out.println();
        });
    }

    @Override
    public void rotateRight() {
        List<List<Pixel>> result = getEmptyScreen(ySize, xSize);
        for (int i = 0; i < xSize; i++)
            for (int j = 0; j < ySize; j++)
                result.get(j).set(xSize - 1 - i, screen.get(i).get(j));
        this.ySize = xSize;
        this.xSize = result.size();
        screen = result;
    }

    @Override
    public void rotateLeft() {
        List<List<Pixel>> result = getEmptyScreen(ySize, xSize);
        for (int i = 0; i < xSize; i++)
            for (int j = 0; j < ySize; j++)
                result.get(ySize - 1 - j).set(i, screen.get(i).get(j));
        this.ySize = xSize;
        this.xSize = result.size();
        screen = result;
    }

    private List<List<Pixel>> getEmptyScreen(int xSize, int ySize) {
        List<List<Pixel>> result = new ArrayList<>();
        IntStream.range(0, xSize).forEach(x -> {
            ArrayList<Pixel> pixels = new ArrayList<>();
            IntStream.range(0, ySize).forEach(y ->
                    pixels.add(Pixel.WHITE));
            result.add(pixels);
        });
        return result;
    }

    enum Pixel {
        WHITE(" "), BLACK("*");
        private String filler;

        Pixel(String filler) {
            this.filler = filler;
        }

        public String getFiller() {
            return filler;
        }
    }
} 

