package codejam2022qualification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PunchedCards {

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
            writer.printf("Case #%d:\n", i);
            writer.println(result);
        }
        writer.flush();
    }

    private static String evaluate(Scanner input) {
        int r = input.nextInt();
        int c = input.nextInt();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 2 * r + 1; i++) {
            for (int j = 0; j < 2 * c + 1; j++) {
                if (i < 2 && j < 2 || i % 2 != 0 && j % 2 != 0) {
                    builder.append(".");
                } else if (i % 2 == 0 && j % 2 == 0 ) {
                    builder.append("+");
                } else if (i % 2 == 0 && j % 2 != 0) {
                    builder.append("-");
                } else if (i % 2 != 0 && j % 2 == 0) {
                    builder.append("|");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
