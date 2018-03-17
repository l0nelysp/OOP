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
public interface Shape {
    void draw(Screen screen);
    void move(Point p);
    Point getLeftTop();
    Point getRightTop();
    Point getLeftBottom();
    Point getRightBottom();
}

