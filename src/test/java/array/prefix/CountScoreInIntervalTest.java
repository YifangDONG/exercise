package array.prefix;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountScoreInIntervalTest {
    private int[] scores = new int[]{1, 2, 3, 4, 5};
    private final CountScoreInInterval countScoreInInterval = new CountScoreInInterval(scores);

    @Test
    public void zeroCountInInterval() {
        int count = countScoreInInterval.queryCount(10, 20);
        assertEquals(0, count);
    }

    @Test
    public void intervalFromZero() {
        int count = countScoreInInterval.queryCount(0, 5);
        assertEquals(5, count);
    }

    @Test
    public void anyInterval() {
        int count = countScoreInInterval.queryCount(2, 3);
        assertEquals(2, count);
    }
}