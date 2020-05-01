package algorithms.dynamicprog;

// https://www.youtube.com/watch?v=yZWmS6CXbQc&t=799s
public class LongestPalindromicSubsequence {

    public static String of(String input) {

        if (input.length() == 0) { return ""; }
        if (input.length() == 1) { return input; }

        char[] inputArray = input.toCharArray();
        int[][] memo = new int[inputArray.length][inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            memo[i][i] = 1;
        }

        int column = 1;
        while (column < inputArray.length) {
            int j = column;
            int i = 0;
            while (i < inputArray.length && j < inputArray.length) {
                if (inputArray[i] == inputArray[j]) {
                    memo[i][j] = 2 + memo[i + 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i + 1][j], memo[i][j - 1]);
                }
                i++;
                j++;
            }
            column++;
        }

        int i = 0;
        int j = inputArray.length - 1;
        char[] resultArray = new char[memo[i][j]];
        int startIndex = 0;
        int endIndex = resultArray.length - 1;

        while (startIndex <= endIndex) {
            if (inputArray[i] == inputArray[j]) {
                resultArray[startIndex] = inputArray[i];
                resultArray[endIndex] = inputArray[i];
                startIndex++;
                endIndex--;
                i++;
                j--;
            } else {
                if (memo[i][j] == memo[i + 1][j]) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return new String(resultArray);
    }
}
