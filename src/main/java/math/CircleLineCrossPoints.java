package math;

import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class CircleLineCrossPoints {

    public static List<Point> getCrossPoints(Circle circle, Line line) {
        var r = circle.center.diff(line.a).dotProduct(line.vector()) / line.vector().square();
        var pr = line.a.add(line.vector().product(r));
        double base = Math.sqrt(circle.r() * circle.r() - pr.diff(circle.center()).square());
        if (base <= 2 * Double.MIN_VALUE) {
            // only one cross point
            return List.of(pr);
        } else {
            var e = line.vector().product(1 / Math.sqrt(line.vector().square()));
            return List.of(pr.add(e.product(base)), pr.diff(e.product(base)));
        }
    }

    public static record Point(double x, double y) {

        Point add(Point p) {
            return new Point(x + p.x, y + p.y);
        }

        Point diff(Point p) {
            return new Point(x - p.x, y - p.y);
        }

        Point product(double r) {
            return new Point(x * r, y * r);
        }

        double dotProduct(Point p) {
            return x * p.x + y * p.y;
        }

        double crossProduct(Point p) {
            return x * p.y - y * p.x;
        }

        double square() {
            return x * x + y * y;
        }

        double distance(Point p) {
            return Math.sqrt(diff(p).square());
        }

        double angle(Point p) {
            var cos = this.dotProduct(p) / (Math.sqrt(square()) * Math.sqrt(p.square()));
            return Math.acos(cos);
        }

        Point rotate(double angle) {
            var newX = this.x * cos(angle) - this.y * sin(angle);
            var newY = this.x * sin(angle) + this.y * cos(angle);
            return new Point(newX, newY);
        }
    }

    public static record Circle(Point center, double r) {

    }

    public static record Line(Point a, Point b) {
        Point vector() {
            return b.diff(a);
        }
        double getDistance(Point x) {
            return x.diff(a).crossProduct(a.diff(b)) / a.distance(b);
        }
    }
}
