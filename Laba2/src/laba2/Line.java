
package laba2;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line implements Shape {
    protected Point a;
    protected Point b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Line(int x0, int y0, int x1, int y1) {
        this.a = new Point(x0, y0);
        this.b = new Point(x1, y1);
    }

    public Line(Line source) {
        this.a = source.a;
        this.b = source.b;
    }

    @Override
    public void draw(Screen screen) {
        screen.putLine(a.getX(), a.getY(), b.getX(), b.getY());
    }

    @Override
    public void move(Point p) {
        a.setX(a.getX() + p.getX()); a.setY(a.getY() + p.getY());
        b.setX(b.getX() + p.getX()); b.setY(b.getY() + p.getY());
    }

    @Override
    public Point getLeftTop() {
        return new Point(min(a.getX(), b.getX()), min(a.getY(),
                b.getY()));
    }

    @Override
    public Point getRightTop() {
        return new Point(max(a.getX(), b.getX()), min(a.getY(),
                b.getY()));
    }

    @Override
    public Point getLeftBottom() {
        return new Point(min(a.getX(), b.getX()), max(a.getY(),
                b.getY()));
    }

    @Override
    public Point getRightBottom() {
        return new Point(max(a.getX(), b.getX()), max(a.getY(),
                b.getY()));
    }
}

