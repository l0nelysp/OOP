package laba2;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author andre
 */
public class laba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here Screen screen = new Screen(50, 35);
        Screen screen = new Screen(50, 35);
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Romb(new Point(20, 7), new Point(26, 7),3));
        shapes.add(new Square(new Point(14, 2), new Point(32, 12)));
        

        // Шляпа
        Point p1 = shapes.get(shapes.size() - 1).getLeftBottom();
        p1.setX(p1.getX() - 2);
        p1.setY(p1.getY() + 1);
        Point p2 = shapes.get(shapes.size() - 1).getRightBottom();
        p2.setX(p2.getX()+2);
        p2.setY(p2.getY()+1);
        shapes.add(new Line(p1, p2)); // Линия под шляпой

        p1 = shapes.get(shapes.size() - 1).getLeftBottom();
        p1.setX(p1.getX() + 1);
        p1.setY(p1.getY() + 1);
        p2 = shapes.get(shapes.size() - 1).getRightBottom();
        p2.setX(p2.getX() - 1);
        p2.setY(p2.getY() + 10);
        shapes.add(new Square(p1, p2)); // Голова

        Point eyeLeft = shapes.get(shapes.size() - 1).getLeftTop();
        eyeLeft.setX(eyeLeft.getX() + 2);
        eyeLeft.setY(eyeLeft.getY() + 2);
        Point eyeRight = new Point(eyeLeft.getX() + 2, eyeLeft.getY());
//        shapes.add(new Line(eyeLeft, eyeRight)); // Левый глаз
        shapes.add(new Romb(new Point(16, 17), new Point(18, 17),1));
        eyeRight = shapes.get(shapes.size() - 2).getRightTop();
        eyeRight.setX(eyeRight.getX() - 2);
        eyeRight.setY(eyeRight.getY() + 2);
        eyeLeft = new Point(eyeRight.getX() - 2, eyeRight.getY());
//        shapes.add(new Line(eyeLeft, eyeRight)); // Правый глаз
        shapes.add(new Romb(new Point(28, 17), new Point(30, 17),1));

        Shape leftEye = shapes.get(shapes.size() - 2);
        Shape rightEye = shapes.get(shapes.size() - 1);

        Point nose = new Point(leftEye.getRightTop().getX() + (rightEye.getLeftTop().getX() - leftEye.getRightTop().getX()) / 2, leftEye.getRightTop().getY() + 3);
        shapes.add(new Line(nose, nose)); // Нос
        Shape head = shapes.get(shapes.size() - 4);
        p1 = head.getLeftBottom();
        p1.setX(p1.getX() + 2);
        p1.setY(p1.getY() - 2);
        p2 = head.getRightBottom();
        p2.setX(p2.getX() - 2);
        p2.setY(p2.getY() - 2);
        shapes.add(new Line(p1, p2)); // Рот

        Line costume = new Line(new Point(p1.getX(), p1.getY() + 10), new Point(p2.getX(), p2.getY() + 10));
        shapes.add(costume); //Линия костюма
        p1 = new Point(costume.getLeftBottom().getX(), costume.getLeftBottom().getY() + 1);
        Line leftDot = new Line(p1, p1);
        shapes.add(leftDot); //Левая точка
        p1 = new Point(costume.getRightBottom().getX(), costume.getRightBottom().getY() + 1);
        Line rightDot = new Line(p1, p1);
        shapes.add(rightDot); //Правая точка

        for (Shape shape : shapes) {
            shape.draw(screen);
        }

        screen.rotateRight();
        screen.draw();
    }
    
}
