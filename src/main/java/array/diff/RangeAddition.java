package array.diff;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/range-addition/
 * <p>
 * given a array of length n. The initial value of each element is 0. You will be given k updates.
 * Each updates is present by a triple [startIndex, endIndex, inc].
 * You need to increase the sub array A[startIndex...endIndex] by inc (include startIndex and endIndex)
 * return the array after the updates
 */
public class RangeAddition {
    int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        Arrays.fill(diff, 0);
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            diff[start] += val;
            if (end + 1 < length) {
                diff[end + 1] -= val;
            }
        }
        int[] result = new int[length];
        result[0] = diff[0];
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }
}
