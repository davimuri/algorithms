package algorithms.dynpro;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeMinimumCoinsTest {

    @Test
    public void testCase1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        String expected = "5 * 2 + 1 * 1";
        CoinChangeMinimumCoins coinChanger = new CoinChangeMinimumCoins();
        Assert.assertEquals(expected, coinChanger.solve(coins, amount));
    }

    @Test
    public void testCase2() {
        int[] coins = { 2 };
        int amount = 3;
        String expected = "";
        CoinChangeMinimumCoins coinChanger = new CoinChangeMinimumCoins();
        Assert.assertEquals(expected, coinChanger.solve(coins, amount));
    }

    @Test
    public void testCase3() {
        int[] coins = {2, 5, 10, 1};
        int amount = 27;
        String expected = "10 * 2 + 5 * 1 + 2 * 1";
        CoinChangeMinimumCoins coinChanger = new CoinChangeMinimumCoins();
        Assert.assertEquals(expected, coinChanger.solve(coins, amount));
    }

    @Test
    public void testCase4() {
        int[] coins = {14, 105, 22, 43};
        int amount = 114;
        String expected = "43 * 2 + 14 * 2";
        CoinChangeMinimumCoins coinChanger = new CoinChangeMinimumCoins();
        Assert.assertEquals(expected, coinChanger.solve(coins, amount));
    }

    @Test
    public void testCase5() {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        String expected = "";
        CoinChangeMinimumCoins coinChanger = new CoinChangeMinimumCoins();
        Assert.assertEquals(expected, coinChanger.solve(coins, amount));
    }

}
