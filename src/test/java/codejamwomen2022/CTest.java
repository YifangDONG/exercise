package codejamwomen2022;

import org.junit.Test;

public class CTest {

    @Test
    public void example1() {
        C.test("src/test/java/cjw2022/c_ex1_input.txt", "src/test/java/cjw2022/c_ex1_result.txt");
    }

    @Test
    public void ts1() {
        C.test("src/test/java/cjw2022/c_ts1_input.txt", "src/test/java/cjw2022/c_ts1_result.txt");
    }

    @Test
    public void ts2() {
        C.test("src/test/java/cjw2022/c_ts2_input.txt", "src/test/java/cjw2022/c_ts2_result.txt");
    }
}