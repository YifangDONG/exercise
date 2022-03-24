package array.diff;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 */
public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int length = n + 1;
        int[] diff = new int[length];
        Arrays.fill(diff, 0);
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            diff[first] += seats;
            if (last + 1 < length) {
                diff[last + 1] -= seats;
            }
        }

        int[] result = new int[n];
        result[0] = diff[1];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i + 1];
        }
        return result;
    }
}
