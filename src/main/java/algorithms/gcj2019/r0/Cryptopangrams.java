package algorithms.gcj2019.r0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Cryptopangrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int upperBoundPrimes = in.nextInt();
            int cryptoMessageSize = in.nextInt();
            long[] cryptoMessage = new long[cryptoMessageSize];

            for (int i = 0; i < cryptoMessageSize; i++) {
                cryptoMessage[i] = in.nextLong();
            }

            System.out.printf("Case #%d: %s%n", t, decrypt(cryptoMessage, upperBoundPrimes));
        }
    }

    public static String decrypt(long[] cryptoMessage, int upperBoundPrimes) {
        Set<Integer> primes = sieveOfEratosthenes(upperBoundPrimes);
        log("Initial primes: " + primes.toString());
        int startIndex = findStartIndex(cryptoMessage);
        List<int[]> firstFactorsList = findFactors(cryptoMessage[startIndex], primes);

        for (int[] firstFactors : firstFactorsList) {
            int[] primesForLetter = new int[cryptoMessage.length + 1];
            Set<Integer> chosenPrimes = new HashSet<>();
            int primesForLetterIndex = startIndex;

            primesForLetter[primesForLetterIndex++] = firstFactors[0];
            primesForLetter[primesForLetterIndex++] = firstFactors[1];
            chosenPrimes.add(firstFactors[0]);
            chosenPrimes.add(firstFactors[1]);
            boolean continueNextFirstFactors = false;

            for (int i = startIndex+1; i < cryptoMessage.length && !continueNextFirstFactors; i++) {
                boolean primeAdded = false;

                if (cryptoMessage[i] % primesForLetter[i] == 0) {
                    int nextPrime = (int) (cryptoMessage[i] / primesForLetter[i]);
                    log("nextPrime: " + nextPrime + " cryptoMessage[i]: " + cryptoMessage[i] + " primesForLetter[i]: " + primesForLetter[i]);
                    if (primes.contains(nextPrime)) {
                        primesForLetter[i + 1] = nextPrime;
                        chosenPrimes.add(nextPrime);
                        primeAdded = true;
                    }
                }

                if (!primeAdded && cryptoMessage[i] % primesForLetter[i - 1] == 0) {
                    int nextPrime = (int) (cryptoMessage[i] / primesForLetter[i - 1]);
                    log("nextPrime: " + nextPrime + " cryptoMessage[i]: " + cryptoMessage[i] + " primesForLetter[i-1]: " + primesForLetter[i - 1]);
                    if (primes.contains(nextPrime)) {
                        swap(primesForLetter, i - 1, i);
                        primesForLetter[i + 1] = nextPrime;
                        chosenPrimes.add(nextPrime);
                        primeAdded = true;
                    }
                }

                if (!primeAdded) {
                    continueNextFirstFactors = true;
                }

            }

            if (continueNextFirstFactors) { continue; }

            if (chosenPrimes.size() != 26) { continue; }

            for (int i = startIndex-1; i >= 0; i -= 2) {
                primesForLetter[i] = primesForLetter[startIndex + 1];
                primesForLetter[i-1] = primesForLetter[startIndex];
            }

            List<Integer> chosenPrimesList = new ArrayList<>(chosenPrimes);
            log("Chosen primes: " + chosenPrimesList.toString());
            Collections.sort(chosenPrimesList);
            char[] uncryptMessage = new char[primesForLetter.length];

            for (int i = 0; i < primesForLetter.length && !continueNextFirstFactors; i++) {
                int index = Collections.binarySearch(chosenPrimesList, primesForLetter[i]);
                //assert index >= 0 : "Chosen prime " + primesForLetter[i] + " not found in chosenPrimesList";
                if (index < 0) {
                    continueNextFirstFactors = true;
                }
                uncryptMessage[i] = (char) (index + 65);
            }

            if (continueNextFirstFactors) { continue; }

            return String.valueOf(uncryptMessage);
        }

        return "";
    }

    //source: https://www.geeksforgeeks.org/sieve-of-eratosthenes/
    private static Set<Integer> sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for (int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                primes.add(i);
            }
        }

        return primes;
    }

    private static int findStartIndex(long[] cryptoMessage) {
        int index = 0;
        while (cryptoMessage[index] == cryptoMessage[index+1]) {
            index++;
        }

        return index;
    }

    private static List<int[]> findFactors(long number, Set<Integer> primes) {
        List<int[]> list = new ArrayList<>();
        for (Integer p : primes) {
            if (number % p != 0) continue;

            int toFind = (int)(number / p);
            if (primes.contains(toFind)) {
                list.add(new int[] {p.intValue(), toFind});
            }
        }
        return list;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void log(String message) {
        System.out.println(message);
    }
}
