package codejamwomen2022;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * because the node is <= 10. we can generate the permutation of all paths
 * use the floyd Warshall to pre-calculate the cost between any two node
 * loop the paths to find the min cost
 */
public class CExample {

    private static Map<Integer, List<List<Integer>>> paths = new HashMap<>();

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
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            var n1 = input.nextInt();
            var n2 = input.nextInt();
            var cost = input.nextInt();
            map[n1][n2] = cost;
            map[n2][n1] = cost;
        }

        long[][] costs = new long[n + 1][n + 1];
        FloydWarshall(n, map, costs);

        long minCost = Long.MAX_VALUE;
        var permutation = paths.computeIfAbsent(n, CExample::permutation);
        for (List<Integer> path : permutation) {
            long currCost = 0;
            for (int i = 0; i < n - 1; i++) {
                currCost += costs[path.get(i)][path.get(i + 1)];
            }
            if (currCost < minCost) {
                minCost = currCost;
            }
        }
        return minCost;
    }

    private static void FloydWarshall(int n, int[][] map, long[][] costs) {
        fillMatrix(costs, Integer.MAX_VALUE);
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
                    if (costs[i][j] > costs[i][k] + costs[k][j]) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                    }
                }
            }
        }
    }

    private static void fillMatrix(long[][] matrix, long value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = value;
            }
        }
    }

    private static long bfs(int[][] map, int from, int to) {
        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(from);
        visited.add(from);
        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(from, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == to) {
                    return distances.get(curr);
                }
                List<Integer> adj = new ArrayList<>();
                for (int j = 0; j < map[0].length; j++) {
                    if (map[curr][j] != 0) {
                        adj.add(j);
                    }
                }
                for (int j : adj) {
                    if (!visited.contains(j)) {
                        queue.offer(j);
                        visited.add(j);
                        distances.put(j, distances.get(curr) + map[curr][j]);
                    }
                }
            }
        }
        return distances.get(to);
    }

    private static List<List<Integer>> permutation(int n) {
        var nodes = IntStream.range(1, n + 1)
            .boxed()
            .collect(Collectors.toList());
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(results, nodes, track);
        return results;
    }

    private static void backtrack(List<List<Integer>> results, List<Integer> nodes, LinkedList<Integer> track) {
        if (track.size() == nodes.size()) {
            results.add(new ArrayList<>(track));
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (track.contains(nodes.get(i))) {
                continue;
            }
            track.add(nodes.get(i));
            backtrack(results, nodes, track);
            track.removeLast();
        }
    }
}
