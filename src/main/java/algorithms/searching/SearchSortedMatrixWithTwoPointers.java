package algorithms.searching;

/**
 * Searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class SearchSortedMatrixWithTwoPointers {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        if (cols == 0) return false;
        int i = rows - 1;
        int j = 0;
        while (0 <= i && i < rows && 0 <= j && j < cols) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

}
