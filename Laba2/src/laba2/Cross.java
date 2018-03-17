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
public class Cross implements Shape {
    protected Line first;
    protected Line second;

    public Cross(Point left, Point top) {
        first = new Line(left, new Point(top.getX() + top.getX() - left.getX(), left.getY()));
        second = new Line(top, new Point(top.getX(), left.getY() - top.getY() + top.getY()));
    }

    @Override
    public void draw(Screen screen) {
        first.draw(screen);
        second.draw(screen);
    }

    @Override
    public void move(Point p) {
        first.move(p);
        second.move(p);
    }

    @Override
    public Point getLeftTop() {
        return first.getLeftTop();
    }

    @Override
    public Point getRightTop() {
        return second.getRightTop();
    }

    @Override
    public Point getLeftBottom() {
        return second.getLeftBottom();
    }

    @Override
    public Point getRightBottom() {
        return first.getRightBottom();
    }
}

