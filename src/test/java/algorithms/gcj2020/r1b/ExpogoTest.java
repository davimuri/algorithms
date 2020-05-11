package algorithms.gcj2020.r1b;

import algorithms.gcj2020.AlgorithmIOTester;
import org.junit.Assert;
import org.junit.Test;

public class ExpogoTest {

    @Test
    public void testCase1() {
        String expected = "SEN";
        String actual = Expogo.bfs(2, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        String expected = "NWS";
        String actual = Expogo.bfs(-2, -3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        String expected = "EE";
        String actual = Expogo.bfs(3, 0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        String expected = "IMPOSSIBLE";
        String actual = Expogo.bfs(-1, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCasesFromFile() {
        AlgorithmIOTester.testFromFile(
                Expogo::main,
                "gcj2020/r1b/expogo_input.txt",
                "gcj2020/r1b/expogo_solution.txt");
    }

}
