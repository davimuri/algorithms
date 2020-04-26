package algorithms.dynpro;

// https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
// https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class LongestCommonSubsequence {

    public static int commonChild(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                if (s1arr[i - 1] == s2arr[j - 1]) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i][j-1], memo[i-1][j]);
                }
            }
        }
        return memo[s1.length()][s2.length()];
    }

}
