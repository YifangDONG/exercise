package array.diff;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/car-pooling/
 */
public class CarPoolingTest {
    private CarPooling s = new CarPooling();

    @Test
    public void example() {
        boolean possible = s.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4);
        assertFalse(possible);
    }

    @Test
    public void example2() {
        boolean possible = s.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5);
        assertTrue(possible);
    }
}