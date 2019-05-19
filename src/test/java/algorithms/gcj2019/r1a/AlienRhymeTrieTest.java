package algorithms.gcj2019.r1a;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AlienRhymeTrieTest {

    @Test
    public void testCase1() {
        String[] words = {"TARPOL", "PROL"};
        int actual = AlienRhymeTrie.maxPairWords(words);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testCase2() {
        String[] words = {"TARPOR", "PROL", "TARPRO"};
        int actual = AlienRhymeTrie.maxPairWords(words);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCase3() {
        String[] words = {"CODEJAM", "JAM", "HAM", "NALAM", "HUM", "NOLOM"};
        int actual = AlienRhymeTrie.maxPairWords(words);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void testCase4() {
        String[] words = {"PI", "HI", "WI", "FI"};
        int actual = AlienRhymeTrie.maxPairWords(words);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testCase5() {
        String[] words = {"CODEJAM", "JAM", "HAM", "NALAM", "HUM", "NOLOM", "PQLOM"};
        int actual = AlienRhymeTrie.maxPairWords(words);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void testMinimumNumberOfStringsWithoutMatch() {
        String[] words = {"TARPOL", "PROS"};
        int actual = AlienRhymeTrie.maxPairWords(words);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testMinimumNumberOfStringsWithMinimumtMatch() {
        String[] words = {"ABCS", "DEFS"};
        int actual = AlienRhymeTrie.maxPairWords(words);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testMatchingStringsWithDifferentLength() {
        String[] words = {"APROS", "PROS", "BPROS", "CPROS"};
        int actual = AlienRhymeTrie.maxPairWords(words);
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testToReversedCharArray() {
        String[] words = {"ABC", "DEFG", "OP", "Q"};
        List<String> expected = Arrays.asList("CBA", "GFED", "PO", "Q");
        List<String> reversedWords = AlienRhymeTrie.toReversedCharArray(words);
        Assert.assertEquals(4, reversedWords.size());

        for (int i = 0; i < expected.size(); i++) {
            String exp = expected.get(i);
            String act = reversedWords.get(i);
            Assert.assertEquals(exp, act);
        }
    }
}
