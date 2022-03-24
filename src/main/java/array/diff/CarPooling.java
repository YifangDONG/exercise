package array.diff;

import java.util.SortedMap;
import java.util.TreeMap;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {

        SortedMap<Integer, Integer> diff = new TreeMap<>();
        diff.put(0, 0);
        for (int[] trip : trips) {
            int start = trip[1];
            int end = trip[2];
            int passenger = trip[0];
            diff.put(start, diff.getOrDefault(start, 0) + passenger);
            diff.put(end, diff.getOrDefault(end, 0) - passenger);
        }
        int count = 0;
        for (Integer value : diff.values()) {
            count += value;
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }
}

