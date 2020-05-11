package algorithms.arrays;

/**
 * Given N, positive integer as input
 * fill NxN matrix in spiral with numbers
 * from 1
 *
 */
public class Spiral {
    public static int[][] spiral(int n) {
        if (n <= 0) return null;

        int [][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int[][] matrix = new int[n][n];
        int row = 0;
        int col = 0;
        int directionIndex = 0;
        for (int i = 1; i <= n * n; i++) {
            matrix[row][col] = i;
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
            if (row < 0 || row >= n || col < 0 || col >= n || matrix[row][col] != 0) {
                row -= directions[directionIndex][0];
                col -= directions[directionIndex][1];
                directionIndex = (directionIndex + 1) % 4;
                row += directions[directionIndex][0];
                col += directions[directionIndex][1];
            }
        }
        return matrix;
    }

}
