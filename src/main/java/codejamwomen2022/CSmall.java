package codejamwomen2022;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * When the start node and the end node is the same, the total cost = 2 * sum(cost of each edge)
 * Because we don't need to go back to the start node,
 * min total cost = 2 * sum(cost of each edge) - max( edge back to the start node)
 *
 * The idea is to find the highest cost between 2 nodes.
 */
public class CSmall {

    public static void main(String[] args) {
        var inputStream = System.in;
        var outputStream = System.out;
        executeTask(inputStream, outputStream);
    }

    public static void test(String inputFile, String outputFile) {
        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {
            executeTask(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeTask(InputStream inputStream, OutputStream outputStream) {
        Scanner scanner = new Scanner(inputStream);
        var writer = new PrintWriter(outputStream);
        int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            var result = evaluate(scanner);
            writer.printf("Case #%d: %d\n", i, result);
        }
        writer.flush();
    }

    private static long evaluate(Scanner input) {
        int n = input.nextInt();
        long totalCost = 0;
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            var n1 = input.nextInt();
            var n2 = input.nextInt();
            var cost = input.nextInt();
            totalCost += cost;
            map[n1][n2] = cost;
            map[n2][n1] = cost;
        }

        long[][] costs = new long[n + 1][n + 1];
        // floyd warshall is not quick enough to find the max path for the test set 2
        long maxCost = FloydWarshall(n, map, costs);
        return 2 * totalCost - maxCost;
    }

    private static void fillMatrix(long[][] matrix, long value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = value;
            }
        }
    }

    private static long FloydWarshall(int n, int[][] map, long[][] costs) {
        long max = 0;
        fillMatrix(costs, Long.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    costs[i][j] = 0;
                }
                if (map[i][j] != 0) {
                    costs[i][j] = map[i][j];
                    costs[j][i] = map[i][j];
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (costs[i][j] - costs[i][k] > costs[k][j]) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                        costs[j][i] = costs[i][j];
                        if(costs[i][j] > max) {
                            max = costs[i][j];
                        }
                    }
                }
            }
        }
        return max;
    }

}
