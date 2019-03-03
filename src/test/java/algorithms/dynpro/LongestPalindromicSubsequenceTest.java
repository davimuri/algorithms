package algorithms.dynpro;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongestPalindromicSubsequenceTest {

    @Test
    public void testEvenPalindrome() {
        String input = "adbbca";
        String expected = "abba";
        String actual = LongestPalindromicSubsequence.of(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testOddPalindrome() {
        String input = "adbgcfbea";
        String expected = "abfba";
        String actual = LongestPalindromicSubsequence.of(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyString() {
        String input = "";
        String expected = "";
        String actual = LongestPalindromicSubsequence.of(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testOneCharString() {
        String input = "a";
        String expected = "a";
        String actual = LongestPalindromicSubsequence.of(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllStringIsPalindrome() {
        String input = "aaaaaaaaaaaaaaaaaaaa";
        String expected = input;
        String actual = LongestPalindromicSubsequence.of(input);
        assertEquals(expected, actual);
    }

}
