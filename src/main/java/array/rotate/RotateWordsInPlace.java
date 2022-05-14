package array.rotate;

/**
 * rotate the words in a phase without extra space
 * ex:
 * given s = "hello TOTO"
 * got s = "TOTO hello"
 *
 * idea:
 * reverse the whole phrase, then reverse each word
 * or
 * reverse individual words, then reverse the whole phrase.
 */
public class RotateWordsInPlace {
    public static String reverse(String phrase) {
        return new String(reverseWords(phrase.toCharArray()));
    }

    private static char[] reverseWords(char[] arrays) {
        // revert individual words
        int start = 0;
        for (int end = 0; end < arrays.length; end++) {
            if (arrays[end] == ' ') {
                reverse(arrays, start, end - 1);
                start = end + 1;
            }
        }
        reverse(arrays, start, arrays.length - 1);

        // revert the whole phrase
        reverse(arrays, 0, arrays.length - 1);
        return arrays;
    }

    private static void reverse(char[] arrays, int start, int end) {
        while (start <= end) {
            swap(arrays, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char[] arrays, int start, int end) {
        char temp = arrays[start];
        arrays[start] = arrays[end];
        arrays[end] = temp;
    }
}
