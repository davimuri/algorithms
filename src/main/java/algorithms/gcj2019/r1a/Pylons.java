package algorithms.gcj2019.r1a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pylons {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int rows = in.nextInt();
            int cols = in.nextInt();
            List<int[]> path = path(rows, cols);

            if (path.isEmpty()) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            } else {
                System.out.printf("Case #%d: POSSIBLE%n", t);
                path.stream().forEach(e -> {
                    System.out.println(e[0] + " " + e[1]);
                });
            }

        }
    }

    public static List<int[]> path(int rows, int cols) {
        if (rows * cols <= 9) {
            return Collections.emptyList();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] matrix = new boolean[rows][cols];
                List<int[]> path = pathFromMatrix(i, j, matrix);
                if (path.size() == rows * cols) {
                    return path;
                }
            }
        }

        return Collections.emptyList();
    }

    public static List<int[]> pathFromMatrix(int row, int col, boolean[][] matrix) {
        List<int[]> path = new ArrayList<>(matrix.length * matrix[0].length);
        int[] move = {row, col};

        while (move != null) {
            matrix[move[0]][move[1]] = true;
            path.add(new int[] {move[0]+1, move[1]+1});
            move = nextMoveFromPosition(move[0], move[1], matrix);
        }

        //assert path.size() == matrix.length * matrix[0].length : "Wrong path of size " + path.size()
        //        + " for matrix " + matrix.length + " x " + matrix[0].length;

        return path;
    }

    private static int[] nextMoveFromPosition(int row, int col, boolean[][] matrix) {
        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!matrix[i][j] && row != i && col != j && row - col != i - j && row + col != i + j) {
                    candidates.add(new int[] {i, j});
                }
            }
        }

        return selectMoveFromCandidates(candidates, matrix);
    }

    private static int[] selectMoveFromCandidates(List<int[]> candidates, boolean[][] matrix) {
        int maxFreeCells = -1;
        int[] selected = null;
        for (int[] candidate : candidates) {
            int freeCells = countFreeNeighbors(candidate[0], candidate[1], matrix);
            if (freeCells > maxFreeCells) {
                maxFreeCells = freeCells;
                selected = candidate;
            }
        }
        return selected;
    }

    private static int countFreeNeighbors(int row, int col, boolean[][] matrix) {
        int freeNeighbors = 0;
        freeNeighbors += countFreeCellsInDirection(row, col, 1, 0, matrix);
        freeNeighbors += countFreeCellsInDirection(row, col, 1, 1, matrix);
        freeNeighbors += countFreeCellsInDirection(row, col, 0, 1, matrix);
        freeNeighbors += countFreeCellsInDirection(row, col, -1, 1, matrix);
        freeNeighbors += countFreeCellsInDirection(row, col, -1, 0, matrix);
        freeNeighbors += countFreeCellsInDirection(row, col, -1, -1, matrix);
        freeNeighbors += countFreeCellsInDirection(row, col, 0, -1, matrix);
        freeNeighbors += countFreeCellsInDirection(row, col, 1, -1, matrix);
        return freeNeighbors;
    }

    private static int countFreeCellsInDirection(int row, int col, int orientationX, int orientationY, boolean[][] matrix) {
        int freeNeighbors = 0;
        int r = row + orientationX;
        int c = col + orientationY;
        while (0 <= r && r < matrix.length && 0 <= c && c < matrix[row].length) {
            if (!matrix[r][c]) {
                freeNeighbors++;
            }
            r += orientationX;
            c += orientationY;
        }
        return freeNeighbors;
    }

}
