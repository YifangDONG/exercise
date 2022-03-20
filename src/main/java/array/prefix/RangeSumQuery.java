package array.prefix;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * idea:
 * the sumRange is called lots of time. we need to have an O(1) solution
 * define preSum[i] = sum(a[0], a[1], ... , a[i-1])
 * then sumRange(i, j) = preSum[j+1] - preSum[i]
 */
public class RangeSumQuery {

    private final int[] preSum;

    public RangeSumQuery(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

}
