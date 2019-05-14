package algorithms.gcj2019.r1c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BacterialTactics {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int rows = in.nextInt();
            int cols = in.nextInt();
            char[][] board = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                String rowStr = in.next();
                for (int j = 0; j < cols; j++) {
                    board[i][j] = rowStr.charAt(j);
                }
            }

            int moves = winningOpenings(board);
            System.out.printf("Case #%d: %d%n", t, moves);
        }
    }

    public static int winningOpenings(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        if (board.length == 1 && board[0].length == 1) {
            return 2;
        }

        List<Integer> validRows = identifyValidRows(board);
        List<Integer> validCols = identifyValidCols(board);

        if (validCols.isEmpty() && validRows.isEmpty()) {
            return 0;
        }

        int winningOpenings = 0;

        for (int r : validRows) {
            int moves = countPosibleMovesByRowTaken(board, r, validRows, validCols);
            if (moves % 2 == 0) {
                winningOpenings += board[0].length;
            }
        }
        for (int c : validCols) {
            int moves = countPosibleMovesByColTaken(board, c, validRows, validCols);
            if (moves % 2 == 0) {
                winningOpenings += board.length;
            }
        }

        return winningOpenings;
    }

    private static List<Integer> identifyValidRows(char[][] board) {
        List<Integer> rowIndexes = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            boolean validRow = true;
            for (int j = 0; j < board[i].length && validRow; j++) {
                if (board[i][j] == '#') {
                    validRow = false;
                }
            }
            if (validRow) {
                rowIndexes.add(i);
            }
        }
        return rowIndexes;
    }

    private static List<Integer> identifyValidCols(char[][] board) {
        List<Integer> colIndexes = new ArrayList<>();

        for (int i = 0; i < board[0].length; i++) {
            boolean validCol = true;
            for (int j = 0; j < board.length && validCol; j++) {
                if (board[j][i] == '#') {
                    validCol = false;
                }
            }
            if (validCol) {
                colIndexes.add(i);
            }
        }
        return colIndexes;
    }

    private static int countPosibleMovesByRowTaken(char[][] board, int rowTaken, List<Integer> validRows, List<Integer> validCols) {
        if (rowTaken == 0 || rowTaken == board.length - 1) {
            return (validRows.size() - 1) + validCols.size();
        }
        return (validRows.size() - 1) + (validCols.size() * 2);
    }

    private static int countPosibleMovesByColTaken(char[][] board, int colTaken, List<Integer> validRows, List<Integer> validCols) {
        if (colTaken == 0 || colTaken == board[0].length - 1) {
            return (validCols.size() - 1) + validRows.size();
        }
        return (validCols.size() - 1) + (validRows.size() * 2);
    }

}
