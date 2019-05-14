package algorithms.gcj2019.r0;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class CryptopangramsEuclideanTest {

    @Test
    public void testCase1() {
        BigInteger[] cryptoMessage = toBigIntegerArray(
                new long[] {217, 1891, 4819, 2291, 2987, 3811, 1739, 2491, 4717, 445, 65, 1079, 8383, 5353, 901,
                187, 649, 1003, 697, 3239, 7663, 291, 123, 779, 1007, 3551, 1943, 2117, 1679, 989, 3053});
        String expected = "CJQUIZKNOWBEVYOFDPFLUXALGORITHMS";
        String actual = CryptopangramsEuclidean.decrypt(cryptoMessage);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        BigInteger[] cryptoMessage = toBigIntegerArray(
                new long[] {3292937, 175597, 18779, 50429, 375469, 1651121, 2102, 3722, 2376497, 611683, 489059,
                2328901, 3150061, 829981, 421301, 76409, 38477, 291931, 730241, 959821, 1664197, 3057407, 4267589, 4729181, 5335543});
        String expected = "SUBDERMATOGLYPHICFJKNQVWXZ";
        String actual = CryptopangramsEuclidean.decrypt(cryptoMessage);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        BigInteger[] cryptoMessage = toBigIntegerArray(
                new long[] {15, 15, 15, 35, 217, 1891, 4819, 2291, 2987, 3811, 1739, 2491, 4717, 445, 65, 1079, 8383, 5353, 901,
                187, 649, 1003, 697, 3239, 7663, 291, 123, 779, 1007, 3551, 1943, 2117, 1679, 989, 3053});
        String expected = "ABABCJQUIZKNOWBEVYOFDPFLUXALGORITHMS";
        String actual = CryptopangramsEuclidean.decrypt(cryptoMessage);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        BigInteger[] cryptoMessage = toBigIntegerArray(
                new long[] {15, 15, 15, 21, 217, 1891, 4819, 2291, 2987, 3811, 1739, 2491, 4717, 445, 65, 1079, 8383, 5353, 901,
                187, 649, 1003, 697, 3239, 7663, 291, 123, 779, 1007, 3551, 1943, 2117, 1679, 989, 3053});
        String expected = "BABACJQUIZKNOWBEVYOFDPFLUXALGORITHMS";
        String actual = CryptopangramsEuclidean.decrypt(cryptoMessage);
        Assert.assertEquals(expected, actual);
    }

    private BigInteger[] toBigIntegerArray(long[] longArray) {
        BigInteger[] bigIntegerArray = new BigInteger[longArray.length];
        int i = 0;
        for (long e : longArray) {
            bigIntegerArray[i++] = BigInteger.valueOf(e);
        }
        return bigIntegerArray;
    }
}
