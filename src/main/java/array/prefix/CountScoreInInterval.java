package array.prefix;

import java.util.Arrays;

/**
 * In a competition, the max score is 100. Given score of each one
 * Design an API to query the number of the participants whose score is in the interval (low <= score <= high)
 * <p>
 * idea:
 * count[i] = the number of the score which is between 0 and i included;
 * then count(low, high) = count[high] - count[low - 1];
 */
public class CountScoreInInterval {
    private final int[] count;

    public CountScoreInInterval(int[] scores) {
        count = new int[100 + 1];
        Arrays.fill(count, 0);
        for (int score : scores) {
            count[score]++;
        }
        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] = count[i] + count[i + 1];
        }
    }

    public int queryCount(int low, int high) {
        if (low == 0) {
            return count[high];
        } else {
            return count[high] - count[low - 1];
        }
    }
}
