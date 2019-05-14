package algorithms.gcj2019.r0;

import org.junit.Assert;
import org.junit.Test;

public class DatBaeTest {

    @Test
    public void testBits() {
        String expected = "01010";
        String actual = DatBae.bits(0, 5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFillBits() {
        String bits = "01010";
        int length = 11;
        String expected = "01010010100";
        String actual = DatBae.fillBits(bits, length);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIdentifyBrokenWorkers() {
        char[][] answers = {
                {'0', '0', '1', '0', '1', '0', '1', '0'},
                {'0', '1', '1', '0', '0', '1', '1', '0'},
                {'0', '0', '0', '1', '0', '0', '0', '1'},
        };
        String expected = "1 5";
        String actual = DatBae.identifyBrokenWorkers(answers, answers[0].length + 2, 2,4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIdentifyBrokenWorkersNextToEachOther() {
        char[][] answers = {
                {'0', '0', '1', '0', '1', '0'},
                {'0', '0', '0', '1', '1', '0'},
                {'0', '1', '0', '0', '0', '1'},
        };
        String expected = "1 2 3 5";
        String actual = DatBae.identifyBrokenWorkers(answers, answers[0].length + 4, 4,4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIdentifyBrokenWorkersAtEnd() {
        char[][] answers = {
                {'0', '0', '1', '0', '1', '0'},
                {'0', '0', '0', '1', '1', '0'},
                {'0', '1', '0', '0', '0', '1'},
        };
        String expected = "1 2 3 5 10 11";
        String actual = DatBae.identifyBrokenWorkers(answers, answers[0].length + 6, 6,4);
        Assert.assertEquals(expected, actual);
    }

}
