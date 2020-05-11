package algorithms.gcj2020.r0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Indicium {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        main(in, System.out);
    }

    public static void main(Scanner in, PrintStream out) {
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String result = "IMPOSSIBLE";
            if (isPossible(in.nextInt(), in.nextInt())) {
                result = "POSSIBLE";
            }
            out.printf("Case #%d: %s%n", i, result);
        }
    }

    public static boolean isPossible(int squareSize, int trace) {
        if (trace == squareSize + 1 || trace == (squareSize * squareSize) - 1)
            return false;
        List<int[]> possibleDiagonals = findDiagonal(squareSize, trace);

        if (possibleDiagonals.isEmpty())
            return false;

        if (squareSize == 2)
            return true;

        Set<Integer>[] rowValues = new Set[2];
        rowValues[0] = new HashSet<>(squareSize);
        rowValues[1] = new HashSet<>(squareSize);
        Set<Integer>[] colValues = new Set[squareSize];
        for (int i = 0; i < squareSize; i++) {
            colValues[i] = new HashSet<>(squareSize);
        }
        for (int[] diagonalValues: possibleDiagonals) {
            int[][] square = getSquareWithDiagonal(squareSize, diagonalValues);
            rowValues[0].clear();
            rowValues[1].clear();
            for (int i = 0; i < squareSize; i++) {
                colValues[i].clear();
            }
            rowValues[0].add(square[0][0]);
            rowValues[0].add(square[0][1]);
            rowValues[1].add(square[1][0]);
            rowValues[1].add(square[1][1]);
            colValues[0].add(square[0][0]);
            colValues[0].add(square[1][0]);
            colValues[1].add(square[0][1]);
            colValues[1].add(square[1][1]);
            for (int i = 2; i < squareSize; i++) {
                colValues[i].add(square[0][1]);
            }
            if (fillSquare(square, 0, 2, rowValues, colValues)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds A, B, C numbers than meets the following
     * (A * X) + B + C = trace
     * A, B, C and X are in [1, squareSize] range
     * A, B and C could be equal in some cases
     * @param squareSize
     * @param trace
     * @return
     */
    public static List<int[]> findDiagonal(int squareSize, int trace) {
        List<int[]> candidates = new ArrayList<>();
        for (int b = 1; b <= squareSize; b++) {
            for (int c = 1; c <= squareSize; c++) {
                int sum = trace - b - c;
                for (int a = 1; a <= squareSize; a++) {
                    int x = sum / a;
                    if (sum % a == 0 && x == squareSize - 2) {
                        candidates.add(new int[] {a, b, c});
                    }
                }
            }
        }
        return candidates;
    }

    /**
     * fills diagonal and obvious elements in first two rows.
     * Example of 4x4 square:
     * C A _ _
     * A B _ _
     * _ _ A _
     * _ _ _ A
     * @param squareSize
     * @param diagonalValues
     * @return Only returns the first two rows of the square
     */
    public static int[][] getSquareWithDiagonal(int squareSize, int[] diagonalValues) {
        int[][] square = new int[2][squareSize];
        square[0][0] = diagonalValues[2]; // C
        square[0][1] = diagonalValues[0]; // A
        square[1][0] = diagonalValues[0]; // A
        square[1][1] = diagonalValues[1]; // B
        return square;
    }

    private static boolean fillSquare(int[][] square, int row, int col, Set<Integer>[] rowValues, Set<Integer>[] colValues) {
        if (row >= 2) {
            return true;
        }
        // it's enough to fill first 2 rows
        for (int i = row; i <= 1; i++) {
            for (int j = col; j < square[0].length; j++) {
                if (i != j && square[i][j] == 0) {
                    for (int val = 1; val <= square[0].length; val++) {
                        if (!rowValues[i].contains(val) && !colValues[j].contains(val)) {
                            int[][] clonedSquare = clone(square);
                            clonedSquare[i][j] = val;
                            Set<Integer>[] clonedRowValues = clone(rowValues);
                            clonedRowValues[i].add(val);
                            Set<Integer>[] clonedColValues = clone(colValues);
                            clonedColValues[j].add(val);
                            int newRow = i;
                            int newCol = j + 1;
                            if (newCol >= square[0].length) {
                                newCol = 2;
                                newRow += 1;
                            }
                            if (fillSquare(clonedSquare, newRow, newCol, clonedRowValues, clonedColValues)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static Set<Integer>[] clone(Set<Integer>[] sets) {
        Set<Integer>[] clone = new Set[sets.length];
        for (int i = 0; i < sets.length; i++) {
            clone[i] = new HashSet<>();
            clone[i].addAll(sets[i]);
        }
        return clone;
    }

    private static int[][] clone(int[][] latinSquare) {
        int[][] clone = new int[latinSquare.length][latinSquare[0].length];
        for (int i = 0; i < latinSquare.length; i++) {
            clone[i] = Arrays.copyOf(latinSquare[i], latinSquare[i].length);
        }
        return clone;
    }

}
