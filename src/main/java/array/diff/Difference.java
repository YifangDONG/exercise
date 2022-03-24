package array.diff;

/**
 * diff is used in the scenario where we need to frequently add/sub elements in a range
 * ex: given a array nums, we need to add 1 for element in nums[2..6],
 * then minus 3 for elements in nums[0..4], etc.
 * <p>
 * idea:
 * have a diff[i] = nums[i] - nums[i-1]
 * we can get back the nums bu looping the diff
 * add 1 for element in nums[2..6] => diff[2] += 1 && diff[7] -= 1;
 * diff[2] += 1 => all elements after 2 increase 1
 * diff[7] -= 1 => all elements after 7 decrease 1
 * => only elements in nums[2..6] increase 1
 */
public class Difference {
    private int[] diff;

    public Difference(int[] nums) {
        int length = nums.length;
        assert length > 0;
        this.diff = new int[length];
        diff[0] = nums[0];
        for (int i = 1; i < length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
