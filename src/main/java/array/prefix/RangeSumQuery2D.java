package array.prefix;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * preSum[i][j] = the sum of region (0, 0, i - 1, j - 1)
 * sumRegion(r1, c1, r2, c2) = preSum[r2+1][c2+1] - preSum[r1][c2+1] - preSum[r2+1][c1] + preSum[r1][c1]
 *
 *           c1   c2
 *      --------
 *      |   |   |
 * r1   --------
 *      |   |   |
 * r2   --------
 */
public class RangeSumQuery2D {

    private final int[][] preSum;

    public RangeSumQuery2D(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        preSum = new int[row + 1][col + 1];
        preSum[0][0] = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // matrix[i][j] is in the same place as preSum[i+1][j+1]
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] + matrix[i][j] - preSum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}
