package algorithms.gcj2019.r1a;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AlienRhymeTest {

    @Test
    public void testCase1() {
        String[] words = {"TARPOL", "PROL"};
        int actual = AlienRhyme.maxPairWords(words);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testCase2() {
        String[] words = {"TARPOR", "PROL", "TARPRO"};
        int actual = AlienRhyme.maxPairWords(words);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCase3() {
        String[] words = {"CODEJAM", "JAM", "HAM", "NALAM", "HUM", "NOLOM"};
        int actual = AlienRhyme.maxPairWords(words);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void testCase4() {
        String[] words = {"PI", "HI", "WI", "FI"};
        int actual = AlienRhyme.maxPairWords(words);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testCase5() {
        String[] words = {"CODEJAM", "JAM", "HAM", "NALAM", "HUM", "NOLOM", "PQLOM"};
        int actual = AlienRhyme.maxPairWords(words);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void testMinimumNumberOfStringsWithoutMatch() {
        String[] words = {"TARPOL", "PROS"};
        int actual = AlienRhyme.maxPairWords(words);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testMinimumNumberOfStringsWithMinimumtMatch() {
        String[] words = {"ABCS", "DEFS"};
        int actual = AlienRhyme.maxPairWords(words);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testMatchingStringsWithDifferentLength() {
        String[] words = {"APROS", "PROS", "BPROS", "CPROS"};
        int actual = AlienRhyme.maxPairWords(words);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testToReversedCharArray() {
        String[] words = {"ABC", "DEFG", "OP", "Q"};
        List<char[]> expected = new ArrayList<>();
        expected.add(new char[] {'C', 'B', 'A'});
        expected.add(new char[] {'G', 'F', 'E', 'D'});
        expected.add(new char[] {'P', 'O'});
        expected.add(new char[] {'Q'});
        List<char[]> reversedWords = AlienRhyme.toReversedCharArray(words);
        Assert.assertEquals(4, reversedWords.size());

        for (int i = 0; i < expected.size(); i++) {
            char[] exp = expected.get(i);
            char[] act = reversedWords.get(i);
            Assert.assertArrayEquals(exp, act);
        }
    }
}
