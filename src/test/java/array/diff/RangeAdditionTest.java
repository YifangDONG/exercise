package array.diff;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class RangeAdditionTest {

    private RangeAddition s = new RangeAddition();

    @Test
    public void example() {
        int[] modifiedArray = s.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
        int[] expected = new int[]{-2, 0, 3, 5, 3};
        assertArrayEquals(expected, modifiedArray);
    }
}