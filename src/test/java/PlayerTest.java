import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void test1() {
        Player.Point p1 = new Player.Point(1, 1);
        Player.Point p2 = new Player.Point(0, 0);
        Player.Point p = p1.to(p2, 2.8);
        System.out.println(p);
        p = p2.to(p1, 2.8);
        System.out.println(p);
    }

    @Test
    public void test2() {
        Player.Point p1 = new Player.Point(1, 1);
        Player.Point p2 = new Player.Point(1, 0);
        Player.Point p = p1.to(p2, 2);
        System.out.println(p);
        p = p2.to(p1, 2);
        System.out.println(p);
    }
}