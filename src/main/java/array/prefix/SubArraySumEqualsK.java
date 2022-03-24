package array.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * idea:
 * presum + 2 sum (hash solution)
 */
public class SubArraySumEqualsK {
    /*
    example:
    nums = [1, 1, 1], k = 2
    i = 0:
    sum0_i = 1, sum0_j = -2, preSum = {0:1, 1:1}, count = 0;
    i = 1:
    sum0_i = 2, sum0_j = 0, preSum = {0:1, 1:1, 2:1}, count = 1;
    i = 2:
    sum0_i = 3, sum0_j = 1, preSum = {0:1, 1:1, 2:1, 3:1}, count = 2;
     */

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // TODO why do I need this init value ?
        int sum0_i = 0; // sum0_i = sum(nums[0],...,nums[i])
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                count += preSum.get(sum0_j);
            }
            preSum.compute(sum0_i, (key, value) -> value == null ? 1 : value + 1);
            // or preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        /*
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
            // this for is used to count how many j which makes preSum[j] = preSum[i] - k
            // We can use a hash map to memorise each preSum how much times it occurs
                if (preSum[j] == preSum[i] - k) {
                    count++;
                }
            }
        }
         */
        return count;
    }

}
