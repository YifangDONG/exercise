package array.diff;

import org.junit.Test;

import static org.junit.Assert.*;

public class CorpFlightBookingsTest {
    private CorpFlightBookings s = new CorpFlightBookings();

    @Test
    public void example() {
        int[] bookings = s.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
        int[] expected = new int[]{10, 55, 45, 25, 25};
        assertArrayEquals(expected, bookings);
    }

    @Test
    public void example2() {
        int[] bookings = s.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2);
        int[] expected = new int[]{10, 25};
        assertArrayEquals(expected, bookings);
    }

    @Test
    public void example3() {
        int[] bookings = s.corpFlightBookings(new int[][]{{3, 3, 5}, {1, 3, 20}, {1, 2, 15}}, 3);
        int[] expected = new int[]{35, 35, 25};
        assertArrayEquals(expected, bookings);
    }

}