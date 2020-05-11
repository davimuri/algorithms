package algorithms.gcj2020.r0;

import org.junit.Assert;
import org.junit.Test;

public class NestingDepthTest {

    @Test
    public void testCaseZero() {
        String input = "0";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("0", actual);
    }

    @Test
    public void testCaseSimple() {
        String input = "3";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("(((3)))", actual);
    }

    @Test
    public void testCaseTwoDigitsEqual() {
        String input = "22";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("((22))", actual);
    }

    @Test
    public void testCaseIncreasingSequence() {
        String input = "12";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("(1(2))", actual);
    }

    @Test
    public void testCaseDecreasingSequence() {
        String input = "21";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("((2)1)", actual);
    }

    @Test
    public void testCaseWithZeroInMiddle() {
        String input = "101";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("(1)0(1)", actual);
    }

    @Test
    public void testCaseWithZeroAtEnd() {
        String input = "222000";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("((222))000", actual);
    }

    @Test
    public void testCaseWithZeroAtStart() {
        String input = "000222";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("000((222))", actual);
    }

    @Test
    public void testCase1() {
        String input = "021";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("0((2)1)", actual);
    }

    @Test
    public void testCase2() {
        String input = "312";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("(((3))1(2))", actual);
    }

    @Test
    public void testCase3() {
        String input = "4";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("((((4))))", actual);
    }

    @Test
    public void testCase4() {
        String input = "221";
        NestingDepth nd = new NestingDepth();
        String actual = nd.nest(input);
        Assert.assertEquals("((22)1)", actual);
    }

}
