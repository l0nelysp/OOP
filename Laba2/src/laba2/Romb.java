package laba2;

public class Romb implements Shape {
       protected Line leftT, rightT, rightB, leftB;
       
    public Romb(Point left, Point right, int wer){
        leftT = new Line(left, new Point(left.getX() + wer, right.getY() - wer));
        rightT = new Line(new Point (left.getX() + wer, right.getY() - wer), right);
        rightB = new Line(new Point (left.getX() + wer, right.getY() + wer), right);
        leftB = new Line(left, new Point(left.getX() + wer, right.getY() + wer));
    }

    public Romb(Point left, Point right) {
        leftT = new Line(left, new Point(left.getX() + 2, right.getY() - 2));
        rightT = new Line(new Point (left.getX() + 2, right.getY() - 2), right);
        rightB = new Line(new Point (left.getX() + 2, right.getY() + 2), right);
        leftB = new Line(left, new Point(left.getX() + 2, right.getY() + 2));
    }

    @Override
    public void draw(Screen screen) {
        leftT.draw(screen);
        rightT.draw(screen);
        rightB.draw(screen);
        leftB.draw(screen);
    }

    @Override
    public void move(Point p) {
        leftT.move(p);
        rightT.move(p);
        rightB.move(p);
        leftB.move(p);
    }

    @Override
    public Point getLeftTop() {
        return leftT.getLeftTop();
    }

    @Override
    public Point getRightTop() {
        return rightT.getRightTop();
    }

    @Override
    public Point getLeftBottom() {
        return leftT.getLeftBottom();
    }

    @Override
    public Point getRightBottom() {
        return rightT.getRightBottom();
    }
}
