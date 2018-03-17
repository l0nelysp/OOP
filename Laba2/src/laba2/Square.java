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
public class Square implements Shape {
    protected Line left, top, right, bottom;

    public Square(Point leftTop, Point rightBottom) {
        left = new Line(leftTop, new Point(leftTop.getX(), rightBottom.getY()));
        top = new Line(leftTop, new Point(rightBottom.getX(), leftTop.getY()));
        right = new Line(new Point(rightBottom.getX(), leftTop.getY()), rightBottom);
        bottom = new Line(new Point(leftTop.getX(), rightBottom.getY()), rightBottom);
    }

    @Override
    public void draw(Screen screen) {
        left.draw(screen);
        top.draw(screen);
        right.draw(screen);
        bottom.draw(screen);
    }

    @Override
    public void move(Point p) {
        left.move(p);
        top.move(p);
        right.move(p);
        bottom.move(p);
    }

    @Override
    public Point getLeftTop() {
        return left.getLeftTop();
    }

    @Override
    public Point getRightTop() {
        return right.getRightTop();
    }

    @Override
    public Point getLeftBottom() {
        return left.getLeftBottom();
    }

    @Override
    public Point getRightBottom() {
        return right.getRightBottom();
    }
}

