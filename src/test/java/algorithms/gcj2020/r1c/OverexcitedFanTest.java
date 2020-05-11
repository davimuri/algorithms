package algorithms.gcj2020.r1c;

import algorithms.gcj2020.AlgorithmIOTester;
import org.junit.Assert;
import org.junit.Test;

public class OverexcitedFanTest {

    @Test
    public void testCase1() {
        int actual = OverexcitedFan.solveNorthSouthPath(4, 4, "SSSS");
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testCase2() {
        int actual = OverexcitedFan.solveNorthSouthPath(3, 0, "SNSS");
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testCase3() {
        int actual = OverexcitedFan.solveNorthSouthPath(2, 10, "NSNNSN");
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testCase4() {
        int actual = OverexcitedFan.solveNorthSouthPath(0, 1, "S");
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testCase5() {
        int actual = OverexcitedFan.solveNorthSouthPath(2, 7, "SSSSSSSS");
        Assert.assertEquals(5, actual);
    }

    @Test
    public void testCase6() {
        int actual = OverexcitedFan.solve(3, 2, "SSSW");
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testCase7() {
        int actual = OverexcitedFan.solve(4, 0, "NESW");
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testFromFile() {
        AlgorithmIOTester.testFromFile(
                OverexcitedFan::main,
                "gcj2020/r1c/overexcited_fan_input.txt",
                "gcj2020/r1c/overexcited_fan_solution.txt");
    }
}
