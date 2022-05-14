package math;

import static math.CircleLineCrossPoints.getCrossPoints;
import org.junit.Test;

public class CircleLineCrossPointsTest {

    @Test
    public void example() {
        var center =  new CircleLineCrossPoints.Point(0,0);
        var circle = new CircleLineCrossPoints.Circle(center, 5);
        var c1 = new CircleLineCrossPoints.Point(3, 4);
        var c2 = new CircleLineCrossPoints.Point(-3, -4);
        var line = new CircleLineCrossPoints.Line(c1, c2);
        var crossPoints = getCrossPoints(circle, line);
        System.out.println(crossPoints);
    }

    @Test
    public void acos() {
        var p1 = new CircleLineCrossPoints.Point(1, 1);
        var p2 = new CircleLineCrossPoints.Point(1, 1);
        var angle = p1.angle(p2);
        System.out.println(angle);
    }

    @Test
    public void rotate() {
        var circleLineCrossPoints = new CircleLineCrossPoints();
        var p1 = new CircleLineCrossPoints.Point(2, 0);
        var p2 = p1.rotate(Math.PI / 3);
        var p3 = p2.rotate(Math.PI / 3);
        System.out.println(p2);
        System.out.println(p3);
    }

    @Test
    public void toto() {
        double t = 3.14;
        System.out.println(Math.floor(t));
        System.out.println(Math.ceil(t));
    }
}
