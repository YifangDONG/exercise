package array.rotate;

import static org.junit.Assert.*;
import org.junit.Test;

public class RotateWordsInPlaceTest {

    @Test
    public void example() {
        var s = "hello TOTO";
        var reverse = RotateWordsInPlace.reverse(s);
        assertEquals("TOTO hello", reverse);
    }
}