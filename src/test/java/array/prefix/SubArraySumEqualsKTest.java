package array.prefix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubArraySumEqualsKTest {
    private SubArraySumEqualsK s = new SubArraySumEqualsK();
    @Test
    public void example() {
        int count = s.subarraySum(new int[]{1, -1, 1}, 1);
        assertEquals(3, count);
    }

    @Test
    public void example2() {
        int count = s.subarraySum(new int[]{1, -1, 1}, 0);
        assertEquals(2, count);
    }
}