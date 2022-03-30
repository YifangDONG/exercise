package codejamwomen2022;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * loop each order:
 * 1. add the delivery which is not later than the order time
 * 2. use the delivery which has the smallest expiry time
 * 3. return if the order cannot be satisfied
 */
public class B {

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
        int d = input.nextInt();
        int o = input.nextInt();
        int u = input.nextInt();
        int[][] delivers = new int[d][3]; // 0 d-time, 1- counts, 2- remain-time
        for (int i = 0; i < d; i++) {
            delivers[i][0] = input.nextInt();
            delivers[i][1] = input.nextInt();
            delivers[i][2] = input.nextInt();
        }
        int[] orders = new int[o];
        for (int i = 0; i < o; i++) {
            orders[i] = input.nextInt();
        }

        PriorityQueue<int[]> store = new PriorityQueue<>(Comparator.comparingInt(deliver -> deliver[0] + deliver[2]));
        int t = 0;
        for (int i = 0; i < o; i++) {
            while(t < d && delivers[t][0] <= orders[i]) { // add only delivery not later than order
                store.offer(delivers[t]);
                t++;
            }

            int remain = u;
            while (remain > 0 && !store.isEmpty()) {
                var deliver = store.poll();
                if (deliver[0] + deliver[2] > orders[i]) { // not expiry
                    long used = Math.min(remain, deliver[1]);
                    remain -= used;
                    deliver[1] -= used;
                    if (deliver[1] > 0) {
                        store.offer(deliver);
                    }
                }
            }
            if(remain > 0) {
                return i;
            }
        }
        return o;
    }
}
