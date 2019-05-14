package algorithms.gcj2019;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CruiseControlTest {

    private final static double delta = Math.pow(10, -6);

    @Test
    public void testCase1() {
        int destination = 2525;
        int[] kmsSpeed = {2400, 5};
        List<int[]> positionAndSpeed = new ArrayList<>();
        positionAndSpeed.add(kmsSpeed);
        float expected = 101;
        Assert.assertEquals(expected,
                CruiseControl.calculateSpeed(destination, positionAndSpeed), delta);
    }

    @Test
    public void testCase2() {
        int destination = 300;
        List<int[]> positionAndSpeed = new ArrayList<>();
        positionAndSpeed.add(new int[] {120, 60});
        positionAndSpeed.add(new int[] {60, 90});
        float expected = 100;
        Assert.assertEquals(expected,
                CruiseControl.calculateSpeed(destination, positionAndSpeed), delta);
    }

    @Test
    public void testCase3() {
        int destination = 100;
        List<int[]> positionAndSpeed = new ArrayList<>();
        positionAndSpeed.add(new int[] {80, 100});
        positionAndSpeed.add(new int[] {70, 10});
        float expected = 33.333333f;
        Assert.assertEquals(expected,
                CruiseControl.calculateSpeed(destination, positionAndSpeed), delta);
    }

}
