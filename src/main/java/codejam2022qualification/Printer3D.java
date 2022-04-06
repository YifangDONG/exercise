package codejam2022qualification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Printer3D {

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
            writer.printf("Case #%d: %s\n", i, result);
        }
        writer.flush();
    }

    private static String evaluate(Scanner input) {
        int[][] incs = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                incs[i][j] = input.nextInt();
            }
        }
        int[] max = new int[4];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            max[i] = capacity(incs, i);
            sum += max[i];
        }
        if (sum < 1_000_000) {
            return "IMPOSSIBLE";
        } else {
            int remain = 1_000_000;
            int[] results = new int[]{
                0, 0, 0, 0
            };
            for (int i = 0; i < 4; i++) {
                if (remain > max[i]) {
                    remain -= max[i];
                    results[i] = max[i];
                } else {
                    results[i] = remain;
                    break;
                }
            }
            return String.format("%d %d %d %d", results[0], results[1], results[2], results[3]);
        }
    }

    private static int capacity(int[][] incs, int col) {
        return Math.min(Math.min(incs[0][col], incs[1][col]), incs[2][col]);
    }
}
