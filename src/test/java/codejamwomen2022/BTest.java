package codejamwomen2022;

import org.junit.Test;

public class BTest {

    @Test
    public void ts2() {
        B.test("src/test/java/cjw2022/b_ts2_input.txt", "src/test/java/cjw2022/b_ts2_results.txt");
    }
    @Test
    public void ex1() {
        B.test("src/test/java/cjw2022/b_ex1_input.txt", "src/test/java/cjw2022/b_ex1_results.txt");
    }
    @Test
    public void ex2() {
        B.test("src/test/java/cjw2022/b_ex2_input.txt", "src/test/java/cjw2022/b_ex2_results.txt");
    }
}