package algorithms.gcj2019.r0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class CryptopangramsEuclidean {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int upperBoundPrimes = in.nextInt();
            int cryptoMessageSize = in.nextInt();
            BigInteger[] cryptoMessage = new BigInteger[cryptoMessageSize];

            for (int i = 0; i < cryptoMessageSize; i++) {
                cryptoMessage[i] = in.nextBigInteger();
            }

            System.out.printf("Case #%d: %s%n", t, decrypt(cryptoMessage));
        }
    }

    public static String decrypt(BigInteger[] cryptoMessage) {
        int startIndex = findStartIndex(cryptoMessage);
        // A    B    A    B    C           D
        // 3    5    3    5    7           11

        // 15   15   15   35   77
        //                gcd  35/gcd      77/gcd
        //           3    5
        BigInteger[] primeFactors = new BigInteger[cryptoMessage.length+1];
        Set<BigInteger> primes = new HashSet<>(26);
        BigInteger gcd = cryptoMessage[startIndex].gcd(cryptoMessage[startIndex+1]);
        primeFactors[startIndex] = cryptoMessage[startIndex].divide(gcd);
        primeFactors[startIndex+1] = gcd;
        primes.add(primeFactors[startIndex]);
        primes.add(gcd);

        for (int i = startIndex+2; i <= cryptoMessage.length; i++) {
            primeFactors[i] = cryptoMessage[i-1].divide(primeFactors[i-1]);
            primes.add(primeFactors[i]);
        }


        for (int i = startIndex-1; i >= 0; i -= 2) {
            primeFactors[i] = primeFactors[i+2];
            primeFactors[i-1] = primeFactors[i+1];
        }

        return primesToString(primeFactors, primes);
    }

    private static int findStartIndex(BigInteger[] cryptoMessage) {
        int index = 0;
        while (cryptoMessage[index].equals(cryptoMessage[index+1])) {
            index++;
        }

        return index;
    }

    private static String primesToString(BigInteger[] primeFactors, Set<BigInteger> primes) {
        List<BigInteger> primeList = new ArrayList<>(primes);
        Collections.sort(primeList);

        char[] uncryptMessage = new char[primeFactors.length];

        for (int i = 0; i < primeFactors.length; i++) {
            int index = Collections.binarySearch(primeList, primeFactors[i]);
            assert index >= 0 : "Chosen prime " + primeFactors[i] + " not found in primeList";
            uncryptMessage[i] = (char) (index + 65);
        }

        return String.valueOf(uncryptMessage);

    }
}
