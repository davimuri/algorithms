package algorithms.dynamicprog;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {

    @Test
    public void testCommonChild() {
        String s1 = "HARRY";
        String s2 = "SALLY";
        int expected = 2;
        int actual = LongestCommonSubsequence.commonChild(s1, s2);
        assertEquals(expected, actual);
    }

}
