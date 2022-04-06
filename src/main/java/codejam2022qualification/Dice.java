package codejam2022qualification;

import java.util.Comparator;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. if a straight from A to B can be done => then one from 1 to B-A+1 can be done as well
 */
public class Dice {

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

    private static int evaluate(Scanner input) {
        var N = input.nextInt();
        List<Integer> dices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            dices.add(input.nextInt());
        }
        dices.sort(Comparator.naturalOrder());
        int length = 0;
        for (int di : dices) {
            if (di > length) {
                length++;
            }
        }
        return length;
    }
}
