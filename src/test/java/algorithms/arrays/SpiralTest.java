package algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

public class SpiralTest {

    @Test
    public void testSize1() {
        int[][] expected = {{1}};
        int[][] actual = Spiral.spiral(1);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSize2() {
        int[][] expected = {
                {1, 2},
                {4, 3}};
        int[][] actual = Spiral.spiral(2);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSize3() {
        int[][] expected = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};
        int[][] actual = Spiral.spiral(3);
        Assert.assertArrayEquals(expected, actual);
    }

}
