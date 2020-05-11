package algorithms.gcj2020.r0;

import org.junit.Assert;
import org.junit.Test;

public class IndiciumTest {

    @Test
    public void testPossibleSmallestSquare() {
        Assert.assertTrue(Indicium.isPossible(2, 2));
        Assert.assertTrue(Indicium.isPossible(2, 4));
    }

    @Test
    public void testPossibleSize3() {
        Assert.assertTrue(Indicium.isPossible(3, 6));
        Assert.assertTrue(Indicium.isPossible(3, 3));
    }

    @Test
    public void testImpossible() {
        Assert.assertFalse(Indicium.isPossible(2, 3));
    }

    @Test
    public void testPossibleSize4() {
        Assert.assertTrue(Indicium.isPossible(4, 4));
        Assert.assertTrue(Indicium.isPossible(4, 9));
        Assert.assertTrue(Indicium.isPossible(4, 7));
        Assert.assertTrue(Indicium.isPossible(4, 10));
        Assert.assertTrue(Indicium.isPossible(4, 8));
        Assert.assertTrue(Indicium.isPossible(4, 6));
        Assert.assertTrue(Indicium.isPossible(4, 11));
    }

    //@Test
    public void printTraces() {
        for (int i = 2; i <= 5; i++) {
            Indicium.isPossible(i, -1);
        }
    }

}
