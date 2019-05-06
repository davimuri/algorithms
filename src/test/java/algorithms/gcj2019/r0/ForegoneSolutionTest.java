package algorithms.gcj2019.r0;

import org.junit.Assert;
import org.junit.Test;

public class ForegoneSolutionTest {

    @Test
    public void testCase1() {
        String[] actual = ForegoneSolution.find("4");
        Assert.assertEquals("2", actual[0]);
        Assert.assertEquals("2", actual[1]);
    }

    @Test
    public void testCase2() {
        String[] actual = ForegoneSolution.find("940");
        Assert.assertEquals("920", actual[0]);
        Assert.assertEquals("20", actual[1]);
    }

    @Test
    public void testCase3() {
        String[] actual = ForegoneSolution.find("4444");
        Assert.assertEquals("2222", actual[0]);
        Assert.assertEquals("2222", actual[1]);
    }

}
