package algorithms.gcj2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            //int rows = in.nextInt();
            //int cols = in.nextInt();
            int n = in.nextInt();
            System.out.println(Arrays.toString(readInts(n)));
            String solution = solveTestCase();
            System.out.printf("Case #%d: %s%n", t, solution);
        }
    }

    public static String solveTestCase() {
        return "";
    }

    private static String[] readStrings(int length) {
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = in.next();
        }
        return strings;
    }

    private static int[] readInts(int length) {
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = in.nextInt();
        }
        return ints;
    }

    private static Pair<Integer, Integer>[] readIntegerPairs(int length) {
        Pair<Integer, Integer>[] pairs = new Pair[length];
        for (int i = 0; i < length; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            pairs[i] = new Pair<>(x, y);
        }
        return pairs;
    }

    private static Triplet<Integer, Integer, Integer>[] readIntegerTriplets(int length) {
        Triplet<Integer, Integer, Integer>[] triplets = new Triplet[length];
        for (int i = 0; i < length; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            triplets[i] = new Triplet<>(a, b, c);
        }
        return triplets;
    }

    private static class Pair<X, Y> {
        X x;
        Y y;

        Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Triplet<A, B, C> {
        A a;
        B b;
        C c;

        Triplet(A a, B b, C c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


}
