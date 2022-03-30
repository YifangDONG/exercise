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

/**
 * When the start node and the end node is the same, the total cost = 2 * sum(cost of each edge)
 * Because we don't need to go back to the start node,
 * min total cost = 2 * sum(cost of each edge) - max( edge back to the start node)
 *
 * The idea is to find the longest path in the tree
 * => Algo: Run BFS from any node to find the farthest leaf node. Label that node T. Run another BFS to find the
 * farthest node from T. The path we found in step 2 is the longest path in the tree.
 */
public class C {

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

        var node1 = farthestNode(map, 1);
        var node2 = farthestNode(map, node1);
        long maxCost = bfs(map, node1, node2);
        return 2 * totalCost - maxCost;
    }

    private static long bfs(int[][] map, int from, int to) {
        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(from);
        visited.add(from);
        Map<Integer, Long> distances = new HashMap<>();
        distances.put(from, 0L);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == to) {
                    return distances.get(curr);
                }
                List<Integer> adj = new ArrayList<>();
                for (int j = 1; j < map[0].length; j++) {
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

    private static int farthestNode(int[][] map, int from) {
        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(from);
        visited.add(from);
        Map<Integer, Long> distances = new HashMap<>();
        distances.put(from, 0L);
        int farthestNode = from;
        long max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
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
                        if (distances.get(j) > max) {
                            max = distances.get(j);
                            farthestNode = j;
                        }
                    }
                }
            }
        }
        return farthestNode;
    }

}
