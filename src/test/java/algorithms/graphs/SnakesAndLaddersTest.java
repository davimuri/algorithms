package algorithms.graphs;

import org.junit.Assert;
import org.junit.Test;

public class SnakesAndLaddersTest {

    //@Test
    public void testCase1() {
        int[][] ladders = {{32, 62}, {42, 68}, {12, 98}};
        int[][] snakes = {
                {95, 13},
                {97, 25},
                {93, 37},
                {79, 27},
                {75, 19},
                {49, 47},
                {67, 17}};
        int actual = SnakesAndLadders.quickestWayUp(ladders, snakes);
        Assert.assertEquals(3, actual);
    }

    //@Test
    public void testCase2() {
        int[][] ladders = {
                {8, 52},
                {6, 80},
                {26, 42},
                {2, 72}};
        int[][] snakes = {
                {51, 19},
                {39, 11},
                {37, 29},
                {81, 3},
                {59, 5},
                {79, 23},
                {53, 7},
                {43, 33},
                {77, 21} };
        int actual = SnakesAndLadders.quickestWayUp(ladders, snakes);
        Assert.assertEquals(5, actual);
    }

    @Test
    public void testCaseImpossible() {
        int[][] ladders = {
                {3, 90}};
        int[][] snakes = {
                {99, 10},
                {97, 20},
                {98, 30},
                {96, 40},
                {95, 50},
                {94, 60},
                {93, 70} };
        int actual = SnakesAndLadders.quickestWayUp(ladders, snakes);
        Assert.assertEquals(-1, actual);
    }

}
