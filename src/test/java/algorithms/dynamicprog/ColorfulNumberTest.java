package algorithms.dynamicprog;

import org.junit.Assert;
import org.junit.Test;

public class ColorfulNumberTest {

    @Test
    public void testInputLengthOne() {
        long input = 2;
        boolean actual = ColorfulNumber.isColorful(input);
        Assert.assertFalse(actual);
    }

    @Test
    public void testInputLengthTwoColorful() {
        long input = 23;
        boolean actual = ColorfulNumber.isColorful(input);
        Assert.assertTrue(actual);
    }

    @Test
    public void testInputLengthTwoNonColorful() {
        long input = 66;
        boolean actual = ColorfulNumber.isColorful(input);
        Assert.assertFalse(actual);
    }

    @Test
    public void testInputLength3Colorful() {
        long input = 235;
        boolean actual = ColorfulNumber.isColorful(input);
        Assert.assertTrue(actual);
    }

    @Test
    public void testInputLength3NonColorful() {
        long input = 326;
        boolean actual = ColorfulNumber.isColorful(input);
        Assert.assertFalse(actual);
    }

    @Test
    public void testInputLength4Colorful() {
        long input = 3245;
        boolean actual = ColorfulNumber.isColorful(input);
        Assert.assertTrue(actual);
    }

}
